package com.xyq.ego.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    /**
     * jsp跳转
     * @param uri
     * @return
     */
    @RequestMapping("{uri}")
    public String loadPage(@PathVariable("uri") String uri) {
        return uri;
    }
}
