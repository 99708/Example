package com.xyq.entity;

/**
 * 报销单明细
 * @author Dell
 *
 */
public class ExpenseItem {
	
	/**
	 * 明细表的id
	 */
	private int itemid;
	/**
	 * 报销表的id
	 */
	private int expid;
	/**
	 * 明细类型
	 */
	private String type;
	/**
	 * 每个报销明细的金额
	 */
	private double amount;
	/**
	 * 每个报销明细的详情
	 */
	private String itemdesc;
	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getExpid() {
		return expid;
	}
	public void setExpid(int expid) {
		this.expid = expid;
	}
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
	public String getItemdesc() {
		return itemdesc;
	}
	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}
	
	public ExpenseItem(int itemid, int expid, String type, double amount,
			String itemdesc) {
		super();
		this.itemid = itemid;
		this.expid = expid;
		this.type = type;
		this.amount = amount;
		this.itemdesc = itemdesc;
	}
	public ExpenseItem() {
		super();
	}
	
	@Override
	public String toString() {
		return "ExpenseItem [itemid=" + itemid + ", expid=" + expid + ", type="
				+ type + ", amount=" + amount + ", itemdesc=" + itemdesc + "]";
	}
	
	
	
}
