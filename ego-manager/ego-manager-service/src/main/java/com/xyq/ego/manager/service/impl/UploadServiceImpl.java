package com.xyq.ego.manager.service.impl;

import com.xyq.ego.manager.service.UploadService;
import com.xyq.entity.PictureResult;
import com.xyq.utils.FtpUtils;
import com.xyq.utils.IDUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {

    @Value("${FTP_PATH}")
    private String FTP_PATH;
    @Value("${FTP_HOST}")
    private String FTP_HOST;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_URL}")
    private String FTP_URL;


    /**
     * 图片上传处理
     * @param mf
     * @return
     */
    @Override
    public PictureResult uploadPicService(MultipartFile mf) {

        PictureResult pictureResult = new PictureResult(0, null);

        try {
            //获取图片原来的名字
            String oldName = mf.getOriginalFilename();
            //获取图片后缀
            String ext = oldName.substring(oldName.lastIndexOf("."));
            //生成图片新名称
            String newName = IDUtils.genImageName();
            //给生成的图片名称加后缀
            newName += ext;
            //实现文件的上传
            FtpUtils.uploadFile(FTP_HOST, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_PATH, newName, mf.getInputStream());
            //封装上传图片信息数据
            pictureResult.setUrl(FTP_URL+newName);
            pictureResult.setMessage("ok");
        } catch (Exception e) {
            pictureResult.setError(1);
            pictureResult.setMessage("error");
            e.printStackTrace();
        }
        return pictureResult;
    }
}
