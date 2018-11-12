package com.xyq.dao;

import com.xyq.entity.Emp;
import com.xyq.entity.Expense;
import com.xyq.entity.ExpenseItem;

public interface ExpenseDao {
	public Emp beforeAddExpenseQuery(String empid);

	public void saveExpense(Expense expense);

	public void saveExpenseItem(ExpenseItem expenseItem);

	public int getExpid();

}
