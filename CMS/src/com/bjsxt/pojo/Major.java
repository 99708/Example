package com.bjsxt.pojo;

import java.io.Serializable;

/**
 * 专业信息的实体类
 * @author QiaoZH
 *
 */
public class Major implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer mid;//专业编号
	private String mname;//专业名称
	public Major(Integer mid, String mname) {
		super();
		this.mid = mid;
		this.mname = mname;
	}
	public Major() {
		super();
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "Major [mid=" + mid + ", mname=" + mname + "]";
	}	
}
