package com.xyq.ego.manager.controller;

import com.xyq.ego.manager.service.ManagerItemCatService;
import com.xyq.entity.TreeResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ManagerItemCatController {

    //注入service接口对象
    @Resource
    private ManagerItemCatService managerItemCatServiceImpl;

    /**
     * 声明单元方法，处理根据id加载子节点的请求
     * @return
     */
    @ResponseBody
    @RequestMapping("/item/cat/list")
    public List<TreeResult> itemCatList(@RequestParam(defaultValue = "0") Long id){
        return managerItemCatServiceImpl.loadItemCatListService(id);
    }
}
