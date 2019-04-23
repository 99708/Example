package com.xyq.ego.rpc.service.impl;

import com.xyq.ego.rpc.mapper.TbOrderItemMapper;
import com.xyq.ego.rpc.mapper.TbOrderMapper;
import com.xyq.ego.rpc.mapper.TbOrderShippingMapper;
import com.xyq.ego.rpc.pojo.TbOrder;
import com.xyq.ego.rpc.pojo.TbOrderItem;
import com.xyq.ego.rpc.pojo.TbOrderShipping;
import com.xyq.ego.rpc.service.TbOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbOrderServiceImpl implements TbOrderService {

    //注入mapper对象
    @Resource
    private TbOrderMapper tbOrderMapper;

    @Resource
    private TbOrderItemMapper tbOrderItemMapper;

    @Resource
    private TbOrderShippingMapper tbOrderShippingMapper;

    @Override
    public void saveTbOrderService(TbOrder tbOrder, List<TbOrderItem> list, TbOrderShipping tbOrderShipping) {
        //将订单信息存储到订单表
        tbOrderMapper.insertSelective(tbOrder);
        //将商品信息存储到订单商品信息表
        for(TbOrderItem item:list){
            tbOrderItemMapper.insertSelective(item);
        }
        //将商品物流信息存储到订单物流表中
        tbOrderShippingMapper.insertSelective(tbOrderShipping);
    }
}
