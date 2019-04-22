package com.bjsxt.pojo;

/**
 * 角色实体类
 * @author 
 *
 */
public class Role {
	private int rid;//角色id
	private String rname;//角色名称
	private String rdesc;//角色描述
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRdesc() {
		return rdesc;
	}
	public void setRdesc(String rdesc) {
		this.rdesc = rdesc;
	}
	public Role(int rid, String rname, String rdesc) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.rdesc = rdesc;
	}
	public Role() {
		super();
	}
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rname=" + rname + ", rdesc=" + rdesc + "]";
	}
	
	
}
