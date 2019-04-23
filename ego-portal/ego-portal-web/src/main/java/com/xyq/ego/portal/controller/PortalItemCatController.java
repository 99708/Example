package com.xyq.ego.portal.controller;

import com.xyq.ego.portal.entity.ItemCat;
import com.xyq.ego.portal.service.PortalItemCatSservice;
import com.xyq.utils.JsonUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class PortalItemCatController {
    //注入service对象
    @Resource
    private PortalItemCatSservice portalItemCatSserviceImpl;

    /**
     * 处理加载门户首页的类目信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/item/cat",produces= MediaType.TEXT_HTML_VALUE+";charset=UTF-8")
    public String loadItemCat(){
        ItemCat itemCat = portalItemCatSserviceImpl.loadTbItemCatService();
        String str = JsonUtils.objectToJson(itemCat);
        return str;
    }
}
