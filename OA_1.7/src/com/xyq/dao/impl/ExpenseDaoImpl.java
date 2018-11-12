package com.xyq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xyq.dao.ExpenseDao;
import com.xyq.entity.Emp;
import com.xyq.entity.Expense;
import com.xyq.entity.ExpenseItem;
import com.xyq.util.DBUtil;
import com.xyq.util.DBUtil2;

public class ExpenseDaoImpl implements ExpenseDao {
	/**
	 * 添加员工之前进行查询
	 */
	@Override
	public Emp beforeAddExpenseQuery(String empid) {
		String sql = "select distinct e2.realname from employee e1 "
				+" inner join employee e2 "
				+" on e1.mgrid = e2.empid where e1.empid = ? ";
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Emp emp = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, empid);
			rs = ps.executeQuery();
			while(rs.next()){
				String realname = rs.getString("realname");
				emp = new Emp();
				emp.setRealname(realname);
			}                                 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return emp;
	}
	
	/**
	 * 保存报销表
	 */
	@Override
	public void saveExpense(Expense expense) {
		String sql = "insert into expense ( "
				+ "expid, empid, totalamount, exptime, expdesc, "
				+ "nextauditor, status ) values ("
				+ " ?, ?, ?, ?, ?, ?, ? )";
		Object [] objs = new Object[]{
				expense.getExpid(), expense.getEmp().getEmpid(), expense.getTotalAmount(),
				expense.getExptime(), expense.getExpdesc(), expense.getNextAuditor(), 
				expense.getStatus()
		};
		DBUtil2.executeDML(sql, objs);
	}
	
	/**
	 * 获取expense的序列值
	 */
	@Override
	public int getExpid() {
		String sql = " select sqe_expense_expid.nextval from dual ";
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int nextval = 0;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				nextval = rs.getInt("nextval");
			}                                 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return nextval;
	}

	/**
	 * 保存报销详情表
	 */
	@Override
	public void saveExpenseItem(ExpenseItem expenseItem) {
		String sql = "insert into expenseitem ("
				+ "itemid, expid, type, amount, itemdesc) values ("
				+ " seq_expensitem_itemid.nextval, ?, ?, ?, ? )";
		Object [] objs = new Object[]{
				expenseItem.getExpid(), expenseItem.getType(), expenseItem.getAmount(),
				expenseItem.getItemdesc()
		};
		DBUtil2.executeDML(sql, objs);
		
	}

}
