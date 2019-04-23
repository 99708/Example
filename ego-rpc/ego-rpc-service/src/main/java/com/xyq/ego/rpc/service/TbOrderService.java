package com.xyq.ego.rpc.service;

import com.xyq.ego.rpc.pojo.TbOrder;
import com.xyq.ego.rpc.pojo.TbOrderItem;
import com.xyq.ego.rpc.pojo.TbOrderShipping;

import java.util.List;

/**
 * 订单处理
 */
public interface TbOrderService {
    /**
     * 订单的保存
     * @param tbOrder
     * @param list
     * @param tbOrderShipping
     */
    public void saveTbOrderService(TbOrder tbOrder, List<TbOrderItem> list, TbOrderShipping tbOrderShipping);
}
