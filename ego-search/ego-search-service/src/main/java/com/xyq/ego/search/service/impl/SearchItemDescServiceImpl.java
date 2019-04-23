package com.xyq.ego.search.service.impl;

import com.xyq.ego.rpc.pojo.TbItemDesc;
import com.xyq.ego.rpc.service.TbItemDescService;
import com.xyq.ego.search.service.SearchItemDescService;
import com.xyq.entity.EgoResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SearchItemDescServiceImpl implements SearchItemDescService {

    //注入远程代理对象
    @Resource
    private TbItemDescService tbItemDescServiceProxy;

    @Override
    public String loadItemDescService(Long id) {
        EgoResult egoResult = tbItemDescServiceProxy.loadTbItemDescByIdService(id);
        TbItemDesc data = (TbItemDesc) egoResult.getData();
        return data.getItemDesc();
    }
}
