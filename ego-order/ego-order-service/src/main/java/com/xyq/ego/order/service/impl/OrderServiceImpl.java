package com.xyq.ego.order.service.impl;

import com.xyq.ego.item.entity.CarItem;
import com.xyq.ego.item.service.CarItemService;
import com.xyq.ego.order.service.OrderService;
import com.xyq.ego.rpc.pojo.TbItem;
import com.xyq.ego.rpc.pojo.TbOrder;
import com.xyq.ego.rpc.pojo.TbOrderItem;
import com.xyq.ego.rpc.pojo.TbOrderShipping;
import com.xyq.ego.rpc.service.TbOrderService;
import com.xyq.utils.IDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    //注入远程代理对象
    @Resource
    private CarItemService carItemServiceProxy;

    @Resource
    private TbOrderService tbOrderServiceProxy;

    /**
     * 订单确认
     * @param uid
     * @return
     */
    @Override
    public List<CarItem> loadCarItemListService(Long uid) {
        List<CarItem> carItems = carItemServiceProxy.loadCarItemMapService(uid);
        return carItems;
    }

    /**
     *提交订单
     * @param uid
     * @param tbOrder
     * @param orderShipping
     * @return
     */
    @Override
    public Map<String, String> saveTbOrderService(Long uid, TbOrder tbOrder, TbOrderShipping orderShipping) {
        //获取当前日期
        Date date = new Date();
        //生成订单id
        String orderId = IDUtils.genItemId()+"";
        //远程调用购物车获取所有的商品信息
        List<CarItem> carItems = carItemServiceProxy.loadCarItemMapService(uid);

        //订单对象属性赋值
        tbOrder.setOrderId(orderId);
        tbOrder.setPostFee("123.32");
        tbOrder.setStatus(2);
        tbOrder.setCreateTime(date);
        tbOrder.setUpdateTime(date);
        tbOrder.setPaymentTime(date);
        tbOrder.setConsignTime(date);
        tbOrder.setEndTime(date);
        tbOrder.setCloseTime(date);
        tbOrder.setShippingCode("111000");
        tbOrder.setShippingName("EMS");
        tbOrder.setUserId(uid);
        tbOrder.setBuyerNick("9527");
        tbOrder.setBuyerMessage("需要帅哥配送......");

        //将商品信息转换为List<TbOrderItem>存储
        List<TbOrderItem> tbOrderItems = new ArrayList<>();
        for(CarItem carItem:carItems){
            //生成订单商品编号
            String orderItemId = IDUtils.genItemId()+"";
            TbItem tbItem = carItem.getTbItem();
            TbOrderItem tbOrderItem = new TbOrderItem();
            tbOrderItem.setId(orderItemId);
            tbOrderItem.setItemId(tbItem.getId()+"");
            tbOrderItem.setOrderId(orderId);
            tbOrderItem.setNum(carItem.getNum());
            tbOrderItem.setPicPath(tbItem.getImages()[0]);
            tbOrderItem.setPrice(tbItem.getPrice());
            tbOrderItem.setTitle(tbItem.getTitle());
            tbOrderItem.setTotalFee(carItem.getNum()*tbItem.getPrice());
            tbOrderItems.add(tbOrderItem);
        }

        //订单物流对象属性赋值
        orderShipping.setOrderId(orderId);
        orderShipping.setReceiverPhone("110");
        orderShipping.setReceiverZip("110110");
        orderShipping.setCreated(date);
        orderShipping.setUpdated(date);

        //远程调用rpc中的saveTbOrderService将订单信息存储到数据库
        tbOrderServiceProxy.saveTbOrderService(tbOrder, tbOrderItems, orderShipping);
        //远程调用购物车，清空商品
        carItemServiceProxy.deleteCarItemAllService(uid);
        //返回存储了商品订单ID和总金额的map
        Map<String, String> map = new HashMap<>();
        map.put("orderId", orderId);
        map.put("total", tbOrder.getPayment());
        return map;
    }
}
