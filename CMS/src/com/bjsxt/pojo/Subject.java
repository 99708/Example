package com.bjsxt.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 科目信息实体类
 * @author QiaoZH
 *
 */
public class Subject implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer subid;//科目编号
	private String subname;//科目名称
	private String examtype;//考试类型
	private Date examdate;//考试日期
	
	public Subject(Integer subid, String subname, String examtype, Date examdate) {
		super();
		this.subid = subid;
		this.subname = subname;
		this.examtype = examtype;
		this.examdate = examdate;
	}
	public Subject() {
		super();
	}
	public Integer getSubid() {
		return subid;
	}
	public void setSubid(Integer subid) {
		this.subid = subid;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	
	public String getExamtype() {
		return examtype;
	}
	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}
	public Date getExamdate() {
		return examdate;
	}
	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}
	@Override
	public String toString() {
		return "Subject [subid=" + subid + ", subname=" + subname
				+ ", examtype=" + examtype + ", examdate=" + examdate + "]";
	}
	
}
