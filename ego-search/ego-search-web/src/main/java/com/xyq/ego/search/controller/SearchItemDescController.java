package com.xyq.ego.search.controller;

import com.xyq.ego.search.service.SearchItemDescService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 根据商品id查询商品描述信息
 */
@Controller
public class SearchItemDescController {
    //注入service对象
    @Resource
    private SearchItemDescService searchItemDescServiceImpl;

    @ResponseBody
    @RequestMapping(value="/item/desc/{itemid}", produces = MediaType.TEXT_HTML_VALUE+";charset=utf-8")
    public String itemDesc(@PathVariable Long itemid){
        return searchItemDescServiceImpl.loadItemDescService(itemid);
    }
}
