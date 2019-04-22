package com.xyq.ego.item.controller;

import com.xyq.ego.item.entity.CarItem;
import com.xyq.ego.item.service.CarItemService;
import com.xyq.ego.rpc.pojo.TbUser;
import com.xyq.entity.EgoResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CarItemController {
    //注入service层对象
    @Resource
    private CarItemService carItemServiceImpl;

    /**
     * 将商品加入到购物车中
     * @param itemid
     * @param req
     * @return
     */
    @RequestMapping("/cart/add/{itemid}")
    public String cartAdd(@PathVariable Long itemid, HttpServletRequest req){
        TbUser tbUser = (TbUser) req.getAttribute("tbUser");
        CarItem carItem = carItemServiceImpl.saveItemToCarItem(tbUser.getId(), itemid);
        req.getSession().setAttribute("carItem", carItem);
        req.getSession().setAttribute("url", "http://localhost:8082/item/"+itemid+".html");
        return "redirect:/cartSuccess.html";
    }

    /**
     * 查看用户购物车中的商品
     * @param request
     * @return
     */
    @RequestMapping("/cart/load")
    public String cartList(HttpServletRequest request){
        TbUser tbUser = (TbUser) request.getAttribute("tbUser");
        List<CarItem> carItems = carItemServiceImpl.loadCarItemMapService(tbUser.getId());
        request.setAttribute("map", carItems);
        return "cart";
    }

    /**
     * 根据商品id删除用户购物车中的商品
     * @param request
     * @return
     */
    @RequestMapping("/cart/delete/{itemid}")
    public String cartDelete(@PathVariable Long itemid, HttpServletRequest request){
        TbUser tbUser = (TbUser) request.getAttribute("tbUser");
        carItemServiceImpl.deleteCarItemService(tbUser.getId(), itemid);
        return "forward:/cart/load.html";
    }

    /**
     * 更新用户购物车中的商品数量
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/cart/update/num/{itemid}/{num}")
    public String cartUpdateNum(@PathVariable Long itemid, @PathVariable Integer num, HttpServletRequest request){
        TbUser tbUser = (TbUser) request.getAttribute("tbUser");
        EgoResult egoResult = carItemServiceImpl.updateCarItemNum(tbUser.getId(), itemid, num);
        return "success";
    }

    /**
     * 清空用户购物车
     * @param request
     * @return
     */
    @RequestMapping("/cart/delete/all")
    public String cartDeleteAll(HttpServletRequest request){
        TbUser tbUser = (TbUser) request.getAttribute("tbUser");
        carItemServiceImpl.deleteCarItemAllService(tbUser.getId());
        return "forward:/cart/load.html";
    }
}
