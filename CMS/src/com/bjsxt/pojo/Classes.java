package com.bjsxt.pojo;

import java.io.Serializable;
/**
 * 班级信息实体类
 * @author QiaoZH
 *
 */
public class Classes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer cid;//班级编号
	private Integer grade;//年级
	private Major major;//专业信息
	private String cname;//班级名称
	public Classes(Integer cid, Integer grade, Major major, String cname) {
		super();
		this.cid = cid;
		this.grade = grade;
		this.major = major;
		this.cname = cname;
	}
	public Classes() {
		super();
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Classes [cid=" + cid + ", grade=" + grade + ", major=" + major
				+ ", cname=" + cname + "]";
	}	
}
