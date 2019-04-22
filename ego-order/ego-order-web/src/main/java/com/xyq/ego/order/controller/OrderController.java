package com.xyq.ego.order.controller;

import com.xyq.ego.item.entity.CarItem;
import com.xyq.ego.order.service.OrderService;
import com.xyq.ego.rpc.pojo.TbOrder;
import com.xyq.ego.rpc.pojo.TbOrderShipping;
import com.xyq.ego.rpc.pojo.TbUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    //注入service对象
    @Resource
    private OrderService orderServiceImpl;

    /**
     * 确认订单
     * @param req
     * @return
     */
    @RequestMapping("/order/ordercart")
    public String orderCart(HttpServletRequest req){
        TbUser tbUser = (TbUser) req.getAttribute("tbUser");
        List<CarItem> carItems = orderServiceImpl.loadCarItemListService(tbUser.getId());
        req.setAttribute("cartList", carItems);
        return "ordercart";
    }

    /**
     * 确认订单
     * @param tbOrder
     * @param orderShipping
     * @param req
     * @return
     */
    @RequestMapping("/order/save")
    public String orderSave(TbOrder tbOrder, TbOrderShipping orderShipping, HttpServletRequest req){
        TbUser tbUser = (TbUser) req.getAttribute("tbUser");
        Map<String, String> map = orderServiceImpl.saveTbOrderService(tbUser.getId(), tbOrder, orderShipping);
        req.setAttribute("orderid", map.get("orderId"));
        req.setAttribute("total", map.get("total"));
        return "success";
    }
}
