package com.xyq.ego.rpc.service.impl;

import com.xyq.ego.rpc.mapper.TbItemDescMapper;
import com.xyq.ego.rpc.pojo.TbItemDesc;
import com.xyq.ego.rpc.service.TbItemDescService;
import com.xyq.entity.EgoResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 处理商品信息描述
 */
@Service
public class TbItemDescServiceImpl implements TbItemDescService {

    //注入mapper对象
    @Resource
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public EgoResult loadTbItemDescByIdService(Long id) {
        TbItemDesc tbItemDesc = tbItemDescMapper.selectByPrimaryKey(id);
        //创建结果对象
        EgoResult egoResult = new EgoResult();
        egoResult.setData(tbItemDesc);
        egoResult.setStatus(200);
        return egoResult;
    }
}
