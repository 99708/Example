package com.xyq.ego.rpc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xyq.ego.rpc.mapper.TbItemParamMapper;
import com.xyq.ego.rpc.pojo.TbItemParam;
import com.xyq.ego.rpc.pojo.TbItemParamExample;
import com.xyq.ego.rpc.service.TbItemParamService;
import com.xyq.entity.EgoResult;
import com.xyq.entity.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TbItemParamServiceImpl implements TbItemParamService {

    //注入mapper对象
    @Resource
    private TbItemParamMapper tbItemParamMapper;

    @Override
    public EgoResult loadTbItemParamByCidService(Long cid) {
        //根据类目ld查询规格参数模板信息
        //创建结果对象
        EgoResult egoResult = new EgoResult();

        TbItemParamExample tbItemParamExample = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = tbItemParamExample.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> tbItemParams = tbItemParamMapper.selectByExampleWithBLOBs(tbItemParamExample);
        if(tbItemParams.size() > 0){
            egoResult.setData(tbItemParams.get(0));
            egoResult.setStatus(200);
            return egoResult;
        }
        return egoResult;
    }

    @Override
    public EgoResult saveTbItemParamService(Long cid, String paramData) {

        try {
            Date date = new Date();
            TbItemParam tbItemParam = new TbItemParam();
            tbItemParam.setItemCatId(cid);
            tbItemParam.setParamData(paramData);
            tbItemParam.setCreated(date);
            tbItemParam.setUpdated(date);

            tbItemParamMapper.insertSelective(tbItemParam);

            return EgoResult.ok();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PageResult<TbItemParam> loadTbItemParamListService(Integer page, Integer rows) {
        //创建结果对象
        PageResult<TbItemParam> pageResult = new PageResult<>();
        //分页插件
        Page startPage = PageHelper.startPage(page, rows);
        //查询参数规格模板信息
        TbItemParamExample tbItemParamExample = new TbItemParamExample();
        List<TbItemParam> tbItemParams = tbItemParamMapper.selectByExampleWithBLOBs(tbItemParamExample);
        pageResult.setRows(tbItemParams);
        pageResult.setTotal(startPage.getTotal());
        return pageResult;
    }

    @Override
    public EgoResult deleteTbItemParamService(List<Long> ids) {

        try {
            TbItemParamExample tbItemParamExample = new TbItemParamExample();
            TbItemParamExample.Criteria criteria = tbItemParamExample.createCriteria();
            criteria.andIdIn(ids);
            int num = tbItemParamMapper.deleteByExample(tbItemParamExample);
            return EgoResult.ok();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
