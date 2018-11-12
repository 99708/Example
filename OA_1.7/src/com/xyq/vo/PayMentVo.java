package com.xyq.vo;

import com.google.gson.annotations.SerializedName;

public class PayMentVo {
	@SerializedName(value = "name")
	private String type;
	@SerializedName(value = "value")
	private double amount;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public PayMentVo(String type, double amount) {
		super();
		this.type = type;
		this.amount = amount;
	}
	public PayMentVo() {
		super();
	}
	
}
