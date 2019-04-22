package com.xyq.ego.sso.service.impl;

import com.xyq.ego.rpc.pojo.TbUser;
import com.xyq.ego.rpc.service.TbUserService;
import com.xyq.ego.sso.service.SsoUserService;
import com.xyq.entity.EgoResult;
import com.xyq.utils.CookieUtils;
import com.xyq.utils.JsonUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 用户信息处理
 */
@Service
public class SsoUserServiceImpl implements SsoUserService {

    //注入远程代理对象
    @Resource
    private TbUserService tbUserServiceProxy;

    //注入redisTemplate对象
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 对用户的唯一字段进行验证
     * @param cond
     * @param type
     * @return
     */
    @Override
    public EgoResult loadTbUserByCond(String cond, Integer type) {
        return tbUserServiceProxy.loadTbUserByCond(cond, type);
    }

    /**
     * 用户注册
     * @param tbUser
     * @return
     */
    @Override
    public EgoResult saveUserService(TbUser tbUser) {
        //对密码进行加密
        String pwd = tbUser.getPassword();
        String pwd2 = DigestUtils.md5DigestAsHex(pwd.getBytes());
        tbUser.setPassword(pwd2);
        //执行插入操作
        EgoResult egoResult = tbUserServiceProxy.saveUserService(tbUser);
        return egoResult;
    }

    /**
     * 用后登录
     * @param uname
     * @return
     */
    @Override
    public EgoResult selectUserByUserName(String uname, String pwd, HttpServletRequest req, HttpServletResponse resp) {
        //创建结果对象
        EgoResult egoResult = new EgoResult();
        //根据用户名查询用户信息
        TbUser tbUser = tbUserServiceProxy.selectUserByUserName(uname);
        if(tbUser != null){
            String pwd1 = DigestUtils.md5DigestAsHex(pwd.getBytes());
            if(pwd1.equals(tbUser.getPassword())){
                String token = UUID.randomUUID().toString();
                //将用户信息缓存到redis库中
                redisTemplate.opsForValue().set(token, JsonUtils.objectToJson(tbUser), 30, TimeUnit.MINUTES);
                //将token保存到cookie保存到浏览器中
                CookieUtils.setCookie(req, resp, "sso_token", token);
                egoResult.setStatus(200);
                egoResult.setMsg("ok");
                egoResult.setData(token);
            }else {
                egoResult.setStatus(202);
                egoResult.setMsg("erro");
            }

        }else{
            egoResult.setStatus(201);
            egoResult.setMsg("error");
        }
        return egoResult;
    }

    /**
     * 根据token校验用户
     * @param token
     * @return
     */
    @Override
    public EgoResult loadUserStatusByToken(String token) {
        //创建结果对象
        EgoResult egoResult = new EgoResult();
        //判断token是否为空
        if(!StringUtils.isEmpty(token)){
            String str = (String) redisTemplate.opsForValue().get(token);
            //判断Str是否为空
            if(!StringUtils.isEmpty(str)){
                TbUser tbUser = JsonUtils.jsonToPojo(str, TbUser.class);
                egoResult.setStatus(200);
                egoResult.setMsg("ok");
                egoResult.setData(tbUser);
                return egoResult;
            }


        }
        egoResult.setStatus(201);
        egoResult.setMsg("erro");
        return egoResult;
    }

    /**
     * 安全退出
     * @param token
     * @return
     */
    @Override
    public EgoResult deleteUserStatusByToken(String token) {
        EgoResult egoResult = new EgoResult();
        if(!StringUtils.isEmpty(token)){
            redisTemplate.delete(token);
            egoResult.setStatus(200);
            egoResult.setMsg("ok");
            return egoResult;
        }
        egoResult.setStatus(201);
        egoResult.setMsg("erro");
        return egoResult;
    }
}
