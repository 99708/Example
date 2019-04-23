package com.xyq.ego.manager.controller;

import com.xyq.ego.manager.service.ManagerItemDescService;
import com.xyq.entity.EgoResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ManagerItemDescController {
    //注入service对象
    @Resource
    private ManagerItemDescService managerItemDescServiceImpl;

    @ResponseBody
    @RequestMapping("/rest/item/query/item/desc/{itemid}")
    public EgoResult itemQueryDesc(@PathVariable Long itemid){
        return managerItemDescServiceImpl.loadTbItemDescByIdService(itemid);
    }
}
