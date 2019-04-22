package com.xyq.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.InputStream;

public class FtpUtils {
    /**
     *
     * @param host  ftp主机地址
     * @param port	ftp端口号
     * @param username ftp的用户名
     * @param password ftp的密码
     * @param path  ftp的资源上传路径
     * @param remote ftp的文件的重命名
     * @param file  ftp的上传资源的流对象
     */
    public static void uploadFile(String host,Integer port,String username,String password,String path,String remote,InputStream file){
        try {
            //1、获取ftp的客户端对象
            FTPClient client=new FTPClient();
            //2、获取链接
            client.connect(host, port);
            //3、登录
            client.login(username, password);
            //4、设置文件上传类型
            client.setFileType(FTP.BINARY_FILE_TYPE);
            //5、设置文件上传路径
            if(!client.changeWorkingDirectory(path)){//判断文件路径是否存在,如果不存在则创建
                client.makeDirectory(path);//创建文件存储路径
                client.changeWorkingDirectory(path);//改变路径为存储路径
            }
            //6、上传
            /**
             * remote 表示上传的文件新的名字
             * local 表示本地文件资源流对象
             */
            client.storeFile(remote, file);
            //7、退出登录并断开链接
            client.logout();
            client.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
