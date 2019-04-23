package com.xyq.ego.search.controller;

import com.xyq.ego.rpc.pojo.TbItem;
import com.xyq.ego.search.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class SearchItemController {
    //注入service对象
    @Resource
    private ItemService itemServiceImpl;

    /**
     * 根据商品id查询商品基本信息
     * @param itemid
     * @param model
     * @return
     */
    @RequestMapping("/item/{itemid}")
    public String loadItem(@PathVariable Long itemid, Model model){
        TbItem tbItem = itemServiceImpl.loadTbItemService(itemid);
        model.addAttribute("item", tbItem);
        return "item";
    }
}
