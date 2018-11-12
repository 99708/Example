package com.xyq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xyq.dao.DeptDao;
import com.xyq.entity.Dept;
import com.xyq.util.DBUtil;

public class DeptDaoImpl implements DeptDao {

	/**
	 * 不分页的查询部门信息
	 */
	@Override
	public List<Dept> getDeptList() {
		String sql = "select * from dept order by deptno asc";
		List<Dept> deptList = new ArrayList<Dept>();
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int deptno = rs.getInt("deptno");
				String deptName = rs.getString("deptname");
				String location = rs.getString("location");
				Dept dept = new Dept(deptno, deptName, location);
				deptList.add(dept);
			}
			return deptList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return null;
	}

	@Override
	public int insertDept(Dept dept) {
		String sql = "insert into dept(deptno, deptname, location) values(?, ?, ?)";
		return DBUtil.executeDML(sql, dept.getDeptno(), dept.getDeptname(), dept.getLocation());
	}

	@Override
	public int deleteDept(int deptid) {
		String sql = "delete from dept where deptno = ?";
		return DBUtil.executeDML(sql, deptid);
	}

	@Override
	public Dept updateQuery(int deptid) {
		String sql = "select * from dept where deptno = ? order by deptno asc";
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Dept dept = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, deptid);
			rs = ps.executeQuery();
			while(rs.next()){
				int deptno = rs.getInt("deptno");
				String deptName = rs.getString("deptname");
				String location = rs.getString("location");
				dept = new Dept(deptno, deptName, location);
			}
			return dept;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return null;
	}

	@Override
	public int updateDept(Dept dept) {
		String sql = "update dept set deptname = ?, location = ? where deptno = ?";
		return DBUtil.executeDML(sql, dept.getDeptname(), dept.getLocation(), dept.getDeptno());
	}

}
