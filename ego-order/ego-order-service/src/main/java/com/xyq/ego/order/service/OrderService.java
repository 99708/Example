package com.xyq.ego.order.service;

import com.xyq.ego.item.entity.CarItem;
import com.xyq.ego.rpc.pojo.TbOrder;
import com.xyq.ego.rpc.pojo.TbOrderShipping;

import java.util.List;
import java.util.Map;

/**
 * 订单处理
 */
public interface OrderService {
    /**
     * 确认订单
     * @param uid
     * @return
     */
    public List<CarItem>  loadCarItemListService(Long uid);

    /**
     * 提交订单
     * @param uid
     * @param tbOrder
     * @param tbOrderShipping
     * @return
     */
    public Map<String, String> saveTbOrderService(Long uid, TbOrder tbOrder, TbOrderShipping tbOrderShipping);
}
