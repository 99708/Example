package com.xyq.entity;

import java.io.Serializable;

/**
 * 响应实体类
 */
public class EgoResult implements Serializable {
    /**
     * 响应状态
     */
    private Integer status;
    private String msg;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static EgoResult ok(){
        EgoResult egoResult = new EgoResult();
        egoResult.setStatus(200);
        return  egoResult;
    }
}
