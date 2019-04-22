package com.xyq.ego.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;

@Controller
public class PageController {
    /**
     * jsp跳转
     * @param uri
     * @return
     */
    @RequestMapping("{uri}")
    public String loadPage(@PathVariable("uri") String uri, @RequestParam(required=false) String redirectUrl, Model model) throws UnsupportedEncodingException {
        if(!StringUtils.isEmpty(redirectUrl)){
            redirectUrl = new String(redirectUrl.getBytes("iso-8859-1"), "utf-8");
            model.addAttribute("redirect",redirectUrl);
        }
        return uri;
    }
}
