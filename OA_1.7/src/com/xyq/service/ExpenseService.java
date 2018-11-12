package com.xyq.service;

import com.xyq.entity.Emp;
import com.xyq.entity.Expense;

public interface ExpenseService {
	/**
	 * 添加之前进行的查询
	 * @param empid
	 * @return
	 */
	public Emp beforeAddExpenseQuery(String empid);
	
	/**
	 * 添加报销
	 * @param expense
	 */
	public void addExpense(Expense expense);
}
