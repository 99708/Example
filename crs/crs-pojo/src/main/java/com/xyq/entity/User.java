package com.xyq.entity;
/**
 * 管理员实体类
 * @author Qiao
 *
 */
public class User {
	private Integer uid;//管理员编号
	private String uname;//管理员姓名
	private String pwd;//管理员密码
	private String idcard;//身份证号
	private String sex;//性别
	private String address;//住址
	private String phone;//电话
	private Integer rid;//角色id

    private Role role; //角色对象

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(Integer uid, String uname, String pwd, String idcard, String sex, String address, String phone, Integer rid, Role role) {
        this.uid = uid;
        this.uname = uname;
        this.pwd = pwd;
        this.idcard = idcard;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.rid = rid;
        this.role = role;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", idcard='" + idcard + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", rid=" + rid +
                ", role=" + role +
                '}';
    }
}
