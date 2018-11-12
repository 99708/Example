package com.xyq.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.xyq.dao.ExpenseDao;
import com.xyq.dao.impl.ExpenseDaoImpl;
import com.xyq.entity.Emp;
import com.xyq.entity.Expense;
import com.xyq.entity.ExpenseItem;
import com.xyq.service.ExpenseService;
import com.xyq.util.DBUtil2;
import com.xyq.util.MyException;

public class ExpenseServiceImpl implements ExpenseService {
	
	ExpenseDao expenseDao = new ExpenseDaoImpl();
	
	/**
	 * 添加之前进行的查询
	 * @param empid
	 * @return
	 */
	@Override
	public Emp beforeAddExpenseQuery(String empid) {
		return expenseDao.beforeAddExpenseQuery(empid);
	}
	
	/**
	 * 添加报销
	 * @param expense
	 */
	@Override
	public void addExpense(Expense expense) {
		//涉及两表的插入
		//采用事务 ThreadLocal实现多个sql语句公用一个connection
		
		Connection conn = DBUtil2.getConnection();
		try {
			conn.setAutoCommit(false);
			//获取expid
			int expid = expenseDao.getExpid();
			//设置expid
			expense.setExpid(expid);
			//保存报销总表
			expenseDao.saveExpense(expense);
			
			//获取报销详情表中的内容
			for(int i=0; i<expense.getExpenseItemList().size(); i++){
				ExpenseItem expenseItem = expense.getExpenseItemList().get(i);
				//设置expid
				expenseItem.setExpid(expid);
				//保存报销详情表
				expenseDao.saveExpenseItem(expenseItem);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				//出错进行回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new MyException(e1.getMessage());
			}
			throw new MyException(e.getMessage());
		}finally{
			DBUtil2.closeAll(conn, null, null);
		}
	}

}
