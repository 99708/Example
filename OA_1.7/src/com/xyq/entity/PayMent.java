package com.xyq.entity;

import java.util.Date;

public class PayMent {
	
	private int pid;
	private String paymentid;
	private double amount;
	private Date paytime;
	private int expid;
	private String empid;
	
	private Emp payEmp;
	private Emp expEmp;
	private Expense expense;
	
	
	public PayMent(int pid, String paymentid, double amount, Date paytime,
			int expid, String empid, Emp payEmp, Emp expEmp, Expense expense) {
		super();
		this.pid = pid;
		this.paymentid = paymentid;
		this.amount = amount;
		this.paytime = paytime;
		this.expid = expid;
		this.empid = empid;
		this.payEmp = payEmp;
		this.expEmp = expEmp;
		this.expense = expense;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getPaytime() {
		return paytime;
	}
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	public int getExpid() {
		return expid;
	}
	public void setExpid(int expid) {
		this.expid = expid;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public Emp getPayEmp() {
		return payEmp;
	}
	public void setPayEmp(Emp payEmp) {
		this.payEmp = payEmp;
	}
	public Emp getExpEmp() {
		return expEmp;
	}
	public void setExpEmp(Emp expEmp) {
		this.expEmp = expEmp;
	}
	public Expense getExpense() {
		return expense;
	}
	public void setExpense(Expense expense) {
		this.expense = expense;
	}
	
	
}
