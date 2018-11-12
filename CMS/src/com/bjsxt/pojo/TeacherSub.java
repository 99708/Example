package com.bjsxt.pojo;

import java.util.Date;

/**
 * 任课老师信息查询
 * @author HaoziDada
 *
 */
public class TeacherSub {
	private int tid;   //教师编号
	private String name;	//教师名称
	private String sex;		//教师性别
	private String hiredate; //任职日期
	private String subname;	//任职科目
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	@Override
	public String toString() {
		return "TeacherSub [tid=" + tid + ", name=" + name + ", sex=" + sex
				+ ", hiredate=" + hiredate + ", subname=" + subname + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hiredate == null) ? 0 : hiredate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((subname == null) ? 0 : subname.hashCode());
		result = prime * result + tid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherSub other = (TeacherSub) obj;
		if (hiredate == null) {
			if (other.hiredate != null)
				return false;
		} else if (!hiredate.equals(other.hiredate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (subname == null) {
			if (other.subname != null)
				return false;
		} else if (!subname.equals(other.subname))
			return false;
		if (tid != other.tid)
			return false;
		return true;
	}
	public TeacherSub(int tid, String name, String sex, String hiredate,
			String subname) {
		super();
		this.tid = tid;
		this.name = name;
		this.sex = sex;
		this.hiredate = hiredate;
		this.subname = subname;
	}
	public TeacherSub() {
		super();
	}
	
}
