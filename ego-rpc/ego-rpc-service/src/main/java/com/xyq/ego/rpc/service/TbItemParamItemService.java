package com.xyq.ego.rpc.service;

import com.xyq.entity.EgoResult;

/**
 * 商品参数规格模板内容处理接口
 */
public interface TbItemParamItemService {
    /**
     * 根据id查询商品参数规格模板内容
     * @param itemId
     * @return
     */
    public EgoResult loadTbItemParamItemByItemIdServices(Long itemId);
}
