package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.LoginDao;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.Teacher;
import com.bjsxt.util.DBUtils;

public class LoginDaoImpl implements LoginDao {
	/**
	 * 查询学生
	 * */
	@Override
	public Student getStudentInfo(String uname, String pwd) {
		//声明JDBC变量
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		//声明实体类
		Student stu = new Student();
		//获取链接
		conn = DBUtils.getConnection();
		//创建SQL命令
		String sql = "select * from student where sid=? and pwd=?";
		try {
			//创建Sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, uname);
			ps.setString(2, pwd);
			//执行
			rs=ps.executeQuery();
			//遍历
			while(rs.next()){
				stu.setSid(rs.getInt("sid"));
				stu.setPwd(rs.getString("pwd"));
				stu.setSname(rs.getString("sname"));
				stu.setRid(rs.getInt("rid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return stu;
	}
	/**
	 * 查询老师
	 * */
	@Override
	public Teacher getTeacherInfo(String uname, String pwd,int rid) {
		//声明JDBC变量
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		//声明实体类
		Teacher tea = new Teacher();
		//获取链接
		conn = DBUtils.getConnection();
		//创建SQL命令
		String sql = "select * from teacher where tid=? and pwd=? and rid=?";
		try {
			//创建Sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ps.setInt(3, rid);
			//执行
			rs=ps.executeQuery();
			//遍历
			while(rs.next()){
				tea.setTid(rs.getInt("tid"));
				tea.setPwd(rs.getString("pwd"));
				tea.setTname(rs.getString("tname"));
				tea.setRid(rs.getInt("rid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return tea;
	}
	
	@Override
	public List<Menu> getMenuDao(Integer rid, int pid) {
		//声明jdbc变量
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明变量
		List<Menu> lm=null;
		try {
			//获取连接
			conn=DBUtils.getConnection();
			//创建SQL命令
			String sql="select * from r_menu  rm"+
				" join t_menu  tm "+
				" on  rm.mid=tm.mid "+
				" where rid=? and pid=?	";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setInt(1, rid);
			ps.setInt(2, pid);
			//执行
			rs=ps.executeQuery();
			lm=new ArrayList<Menu>();
			//遍历
			while(rs.next()){
				Menu m=new Menu();
				m.setMid(rs.getInt("mid"));
				m.setMname(rs.getString("mname"));
				m.setMurl(rs.getString("murl"));
				m.setPid(rs.getInt("pid"));
				lm.add(m);
			}
			//关闭资源
			//返回
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, conn);
		}	
		return lm;
	}

}
