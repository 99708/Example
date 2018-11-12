package com.xyq.entity;

import java.util.Date;

public class InCome {

	private int icid;
	private int amount;
	private Date icdate;
	private String ictype;
	private String indesc;
	private String userid;
	
	public InCome() {
		super();
	}
	public InCome(int icid, int amount, Date icdate, String ictype,
			String indesc, String userid) {
		super();
		this.icid = icid;
		this.amount = amount;
		this.icdate = icdate;
		this.ictype = ictype;
		this.indesc = indesc;
		this.userid = userid;
	}
	public int getIcid() {
		return icid;
	}
	public void setIcid(int icid) {
		this.icid = icid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getIcdate() {
		return icdate;
	}
	public void setIcdate(Date icdate) {
		this.icdate = icdate;
	}
	public String getIctype() {
		return ictype;
	}
	public void setIctype(String ictype) {
		this.ictype = ictype;
	}
	public String getIndesc() {
		return indesc;
	}
	public void setIndesc(String indesc) {
		this.indesc = indesc;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
}
