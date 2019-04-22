package com.xyq.ego.manager.service.impl;

import com.xyq.ego.manager.service.ManagerItemDescService;
import com.xyq.ego.rpc.service.TbItemDescService;
import com.xyq.entity.EgoResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品描述信息处理
 */
@Service
public class ManagerItemDescServiceImpl implements ManagerItemDescService {

    //注入远程代理对象
    @Resource
    private TbItemDescService tbItemDescServiceProxy;

    @Override
    public EgoResult loadTbItemDescByIdService(Long id) {
        return tbItemDescServiceProxy.loadTbItemDescByIdService(id);
    }
}
