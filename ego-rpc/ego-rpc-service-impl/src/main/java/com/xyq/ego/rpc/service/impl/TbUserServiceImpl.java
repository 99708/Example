package com.xyq.ego.rpc.service.impl;

import com.xyq.ego.rpc.mapper.TbUserMapper;
import com.xyq.ego.rpc.pojo.TbUser;
import com.xyq.ego.rpc.pojo.TbUserExample;
import com.xyq.ego.rpc.service.TbUserService;
import com.xyq.entity.EgoResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户信息处理
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    //注入mapper对象
    @Resource
    private TbUserMapper tbUserMapper;
    /**
     * 对用户的唯一字段进行验证
     * @param cond
     * @param type
     * @return
     */
    @Override
    public EgoResult loadTbUserByCond(String cond, Integer type) {
        //创建结果对象
        EgoResult egoResult = new EgoResult();
        try {
            //创建TbUserExample封装查询条件
            TbUserExample tbUserExample = new TbUserExample();
            TbUserExample.Criteria criteria = tbUserExample.createCriteria();
            //根据传入的字段不同分别验证
            switch (type){
                case 1:
                    criteria.andUsernameEqualTo(cond);
                    break;
                case 2:
                    criteria.andPhoneEqualTo(cond);
                    break;
                case 3:
                    criteria.andEmailEqualTo(cond);
                    break;
            }
            List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
            egoResult.setStatus(200);
            egoResult.setMsg("ok");
            if(tbUsers !=null && tbUsers.size()>0){
                egoResult.setData(false);//不可用
            }else {
                egoResult.setData(true);//可用
            }
            return egoResult;
        } catch (Exception e) {
            egoResult.setStatus(400);
            egoResult.setMsg("error");
            e.printStackTrace();
        }
        return egoResult;
    }

    /**
     * 用户注册
     * @param tbUser
     * @return
     */
    @Override
    public EgoResult saveUserService(TbUser tbUser) {
        Date date = new Date();
        EgoResult egoResult = new EgoResult();
        tbUser.setCreated(date);
        tbUser.setUpdated(date);
        int num = tbUserMapper.insertSelective(tbUser);
        if(num > 0){
            egoResult.setStatus(200);
            egoResult.setMsg("注册成功");
        }else {
            egoResult.setStatus(400);
            egoResult.setMsg("注册失败. 请校验数据后请再提交数据");
            egoResult.setData("注册成功");
        }
        return egoResult;
    }

    /**
     * 用户登录
     * @param uname
     * @return
     */
    @Override
    public TbUser selectUserByUserName(String uname) {
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andUsernameEqualTo(uname);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
        if(tbUsers != null && tbUsers.size() > 0){
            return tbUsers.get(0);
        }
        return null;
    }
}
