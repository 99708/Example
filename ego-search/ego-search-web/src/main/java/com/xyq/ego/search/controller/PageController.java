package com.xyq.ego.search.controller;

import com.xyq.ego.search.domain.ItemResult;
import com.xyq.ego.search.service.ItemService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@Controller
public class PageController {

    //注入service对象
    @Resource
    private ItemService itemServiceImpl;

    /**
     * jsp跳转
     * @param uri
     * @return
     */
    @RequestMapping("{uri}")
    public String loadPage(@PathVariable("uri") String uri, String q, @RequestParam(defaultValue = "1") Integer page, Model model) throws SolrServerException, UnsupportedEncodingException {
        //设置请求数据编码格式
        q = new String(q.getBytes("iso-8859-1"),"utf-8");
        ItemResult itemResult = itemServiceImpl.loadItemListService(q, page);

        //存放数据到作用域
        model.addAttribute("query", q);
        model.addAttribute("totalPages", itemResult.getMaxpage());
        model.addAttribute("page", page);
        model.addAttribute("total", itemResult.getTotal());
        model.addAttribute("itemList", itemResult.getList());
        return uri;
    }

}
