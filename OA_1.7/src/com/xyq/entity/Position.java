package com.xyq.entity;

import java.io.Serializable;

public class Position implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int posid;
	private String pname;
	private String pdesc;
	
	public int getPosid() {
		return posid;
	}
	public void setPosid(int posid) {
		this.posid = posid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Position(int posid, String pname, String pdesc) {
		this.posid = posid;
		this.pname = pname;
		this.pdesc = pdesc;
	}
	public Position() {}
	@Override
	public String toString() {
		return "Position [posid=" + posid + ", pname=" + pname + ", pdesc="
				+ pdesc + "]";
	}
}
