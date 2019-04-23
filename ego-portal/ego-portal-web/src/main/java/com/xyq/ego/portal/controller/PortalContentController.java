package com.xyq.ego.portal.controller;

import com.xyq.ego.portal.entity.PicResult;
import com.xyq.ego.portal.service.PortalContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PortalContentController {
    //注入service对象
    @Resource
    private PortalContentService portalContentServiceImpl;

    @ResponseBody
    @RequestMapping("/content/index/list")
    public List<PicResult> contentIndexList(Long categoryId){
        List<PicResult> picResults = portalContentServiceImpl.loadContentByCidService(categoryId);
        return picResults;
    }

}
