package com.xyq.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Dell
 *	报销单
 */
public class Expense {
	
	private int expid;
	/**
	 * 报销总金额
	 */
	private double totalAmount;
	private Date exptime;
	private String expdesc;
	/**
	 * 上级(审核人)
	 */
	private String nextAuditor;
	private String lastResult;
	/**
	 * 1：审核中   2 审核结束通过  3 审核结束驳回
	 */
	private String status;
	private Emp emp;
	/**
	 * 报销明细集合
	 */
	private List<ExpenseItem> expenseItemList;
	
	public int getExpid() {
		return expid;
	}
	public void setExpid(int expid) {
		this.expid = expid;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getExptime() {
		return exptime;
	}
	public void setExptime(Date exptime) {
		this.exptime = exptime;
	}
	public String getExpdesc() {
		return expdesc;
	}
	public void setExpdesc(String expdesc) {
		this.expdesc = expdesc;
	}
	public String getNextAuditor() {
		return nextAuditor;
	}
	public void setNextAuditor(String nextAuditor) {
		this.nextAuditor = nextAuditor;
	}
	public String getLastResult() {
		return lastResult;
	}
	public void setLastResult(String lastResult) {
		this.lastResult = lastResult;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public List<ExpenseItem> getExpenseItemList() {
		return expenseItemList;
	}
	public void setExpenseItemList(List<ExpenseItem> expenseItemList) {
		this.expenseItemList = expenseItemList;
	}
	public Expense(int expid, double totalAmount, Date exptime, String expdesc,
			String nextAuditor, String lastResult, String status, Emp emp,
			List<ExpenseItem> expenseItemList) {
		super();
		this.expid = expid;
		this.totalAmount = totalAmount;
		this.exptime = exptime;
		this.expdesc = expdesc;
		this.nextAuditor = nextAuditor;
		this.lastResult = lastResult;
		this.status = status;
		this.emp = emp;
		this.expenseItemList = expenseItemList;
	}
	
	public Expense(int expid, double totalAmount, Date exptime, String expdesc,
			String nextAuditor, String status, Emp emp) {
		super();
		this.expid = expid;
		this.totalAmount = totalAmount;
		this.exptime = exptime;
		this.expdesc = expdesc;
		this.nextAuditor = nextAuditor;
		this.status = status;
		this.emp = emp;
	}
	public Expense(Emp emp, double totalAmount, Date exptime, String expdesc,
			String nextAuditor, String status, List<ExpenseItem> expenseItemList) {
		super();
		this.emp = emp;
		this.totalAmount = totalAmount;
		this.exptime = exptime;
		this.expdesc = expdesc;
		this.nextAuditor = nextAuditor;
		this.status = status;
		this.expenseItemList = expenseItemList;
	}
	
	public Expense() {
		super();
	}
	
	@Override
	public String toString() {
		return "Expense [expid=" + expid + ", totalAmount=" + totalAmount
				+ ", exptime=" + exptime + ", expdesc=" + expdesc
				+ ", nextAuditor=" + nextAuditor + ", lastResult=" + lastResult
				+ ", status=" + status + ", emp=" + emp + ", expenseItemList="
				+ expenseItemList + "]";
	}
}
