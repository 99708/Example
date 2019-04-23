package com.xyq.ego.manager.controller;

import com.xyq.ego.manager.service.UploadService;
import com.xyq.entity.PictureResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Controller
public class UploadController {
    //注入service接口实例化对象
    @Resource
    private UploadService uploadServiceImpl;

    /**
     * 处理商品图片上传请求
     * @param uploadFile
     * @return
     */
    @ResponseBody
    @RequestMapping("/pic/upload")
    public PictureResult picUpload(MultipartFile uploadFile){
        return uploadServiceImpl.uploadPicService(uploadFile);
    }
}
