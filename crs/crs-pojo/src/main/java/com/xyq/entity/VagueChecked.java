package com.xyq.entity;

public class VagueChecked {
	private String checkid;
	private String checkdate;
	private String uname;
	private String rentid;
	public VagueChecked(String checkid, String checkdate, String uname, String rentid) {
		super();
		this.checkid = checkid;
		this.checkdate = checkdate;
		this.uname = uname;
		this.rentid = rentid;
	}
	public VagueChecked() {
		super();
	}
	public String getCheckid() {
		return checkid;
	}
	public void setCheckid(String checkid) {
		this.checkid = checkid;
	}
	public String getCheckdate() {
		return checkdate;
	}
	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getRentid() {
		return rentid;
	}
	public void setRentid(String rentid) {
		this.rentid = rentid;
	}
	@Override
	public String toString() {
		return "VagueChecked [checkid=" + checkid + ", checkdate=" + checkdate + ", uname=" + uname + ", rentid="
				+ rentid + "]";
	}
	
}
