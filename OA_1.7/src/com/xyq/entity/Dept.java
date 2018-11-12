package com.xyq.entity;

import java.io.Serializable;

public class Dept implements Serializable{
	private static final long serialVersionUID = 1L;
	private int deptno;
	private String deptname;
	private String location;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Dept(int deptno, String deptname, String location) {
		this.deptno = deptno;
		this.deptname = deptname;
		this.location = location;
	}
	public Dept() {	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", deptname=" + deptname
				+ ", location=" + location + "]";
	}
}
