package com.xyq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xyq.dao.LoginDao;
import com.xyq.entity.Dept;
import com.xyq.entity.Emp;
import com.xyq.entity.Position;
import com.xyq.util.DBUtil;

public class LoginDaoImpl implements LoginDao {
	/**
	 * 验证登录信息
	 * @param empid
	 * @param password
	 * @return
	 */
	@Override
	public Emp login(String empid, String password) {
		String sql = "select e.realname, e.emptype"
				+ " from employee e "
				+ " where e.empid = ? and e.password =?";
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, empid);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()){
				
				String realname = rs.getString("realname");
				int emptype = rs.getInt("emptype");
				Emp emp = new Emp();
				emp.setEmpid(empid);
				emp.setEmptype(emptype);
				emp.setRealname(realname);
				return  emp;
			}                                 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return null;
	}

}
