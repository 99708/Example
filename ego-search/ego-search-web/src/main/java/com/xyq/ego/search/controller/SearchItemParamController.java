package com.xyq.ego.search.controller;

import com.xyq.ego.search.service.SearchItemParamService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SearchItemParamController {
    //注入service
    @Resource
    private SearchItemParamService searchItemParamServiceImpl;

    @ResponseBody
    @RequestMapping(value = "/item/param/{itemid}", produces = MediaType.TEXT_HTML_VALUE+";charset=utf-8")
    public String itemParam(@PathVariable Long itemid){
        return searchItemParamServiceImpl.loadItemParamsService(itemid);
    }
}
