package com.xyq.ego.manager.controller;

import com.xyq.ego.manager.service.ManagerItemParamItemService;
import com.xyq.entity.EgoResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 商品参数规格模板内容处理
 */
@Controller
public class ManagerItemParamItemController {

    //注入service对象
    @Resource
    private ManagerItemParamItemService managerItemParamItemServiceImpl;

    @ResponseBody
    @RequestMapping("/rest/item/param/item/query/{itemid}")
    public EgoResult itemParamItemQuery(@PathVariable  Long itemid){
        return managerItemParamItemServiceImpl.loadTbItemParamItemByItemIdServices(itemid);
    }
}
