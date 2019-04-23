package com.xyq.entity;
/**
 * 客户实体类
 * @author Qiao
 *
 */
public class Customer {
	private String idcard;//身份证号
	private String cname;//客户姓名
	private String sex;//性别
	private String address;//住址
	private String phone;//电话
	private String job;//职业
	private String pwd;//密码
	public Customer(String idcard, String cname, String sex, String address, String phone, String job, String pwd) {
		super();
		this.idcard = idcard;
		this.cname = cname;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.job = job;
		this.pwd = pwd;
	}
	public Customer() {
		super();
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Customer [idcard=" + idcard + ", cname=" + cname + ", sex=" + sex + ", address=" + address + ", phone="
				+ phone + ", job=" + job + ", pwd=" + pwd + "]";
	}

}
