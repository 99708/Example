package com.xyq.ego.manager.service.impl;

import com.xyq.ego.manager.service.ManagerItemParamItemService;
import com.xyq.ego.rpc.service.TbItemParamItemService;
import com.xyq.entity.EgoResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品参数规格模板内容处理
 */
@Service
public class ManagerItemParamItemServiceImpl implements ManagerItemParamItemService {

    //注入远程代理对象
    @Resource
    private TbItemParamItemService tbItemParamItemServiceProxy;

    /**
     * 根据商品id查询商品参数规格模板内容
     * @param itemId
     * @return
     */
    @Override
    public EgoResult loadTbItemParamItemByItemIdServices(Long itemId) {
        return tbItemParamItemServiceProxy.loadTbItemParamItemByItemIdServices(itemId);
    }
}
