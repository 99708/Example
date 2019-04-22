package com.xyq.ego.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /**
     * 默认跳转index.jsp
     * @return
     */
    @RequestMapping("/")
    public String loadIndex(){
        return "index";
    }

    /**
     * jsp跳转
     * @param uri
     * @return
     */
    @RequestMapping("{uri}")
    public String loadPage(@PathVariable("uri") String uri){
        return uri;
    }
}
