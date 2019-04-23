package com.xyq.vo;

import com.xyq.entity.User;

public class UserLoginVO {

    private Integer lid;//登录信息编号
    private Integer uid;//管理员编号
    private String ip;//登录的ip地址
    private String time;//登录时间
    private User user; //登录者信息

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserLoginVO() {
    }

    public UserLoginVO(Integer lid, Integer uid, String ip, String time, User user) {
        this.lid = lid;
        this.uid = uid;
        this.ip = ip;
        this.time = time;
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserLoginVO{" +
                "lid=" + lid +
                ", uid=" + uid +
                ", ip='" + ip + '\'' +
                ", time='" + time + '\'' +
                ", user=" + user +
                '}';
    }
}
