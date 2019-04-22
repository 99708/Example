package com.xyq.ego.manager.service;

import com.xyq.entity.PictureResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    /**
     * 实现图片上传
     * @param mf
     * @return
     */
    public PictureResult uploadPicService(MultipartFile mf);
}
