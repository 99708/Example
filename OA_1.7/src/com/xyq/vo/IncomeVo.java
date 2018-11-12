package com.xyq.vo;

public class IncomeVo {
	private int amount;
	private String type;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public IncomeVo(int amount, String type) {
		super();
		this.amount = amount;
		this.type = type;
	}
	public IncomeVo() {
		super();
	}
	@Override
	public String toString() {
		return "IncomeVo [amount=" + amount + ", type=" + type + "]";
	}
	
	
}
