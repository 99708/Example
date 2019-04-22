package com.xyq.entity;

/**
 * 上传图片的返回值
 */
public class PictureResult {
    /**
     * 上传图片返回值 0表示成功 1表示失败
     */
    private int error;

    /**
     * 回显图片的url
     */
    private String url;

    /**
     * 错误时的错误消息
     */
    private String message;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PictureResult(int error, String message) {
        this.error = error;
        this.message = message;
    }

    public PictureResult() {
    }
}
