package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.UserDao;
import com.bjsxt.pojo.Classes;
import com.bjsxt.pojo.Major;
import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.Teacher;
import com.bjsxt.util.DBUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public int addUser(Student stu) {
		String sql = " insert into student(sid,pwd,sname,rid) values(?,?,?,?)";
		Object obj[]={stu.getSid(),stu.getPwd(),stu.getSname(),stu.getRid()};
		int i = DBUtils.executeDML(sql, obj);
		return i ;
	}

	@Override
	public int addUser(Teacher tea) {
		String sql = "insert into teacher(tid,pwd,tname,rid) values(?,?,?,?)";
		Object obj[]={tea.getTid(),tea.getPwd(),tea.getTname(),tea.getRid()};
		int executeDML = DBUtils.executeDML(sql, obj);
		return executeDML;
	}


	/**
	 * 根据登陆用户名查询学生
	 * */
	@Override
	public Student getStudentInfo1(String str) {
		//声明JDBC变量
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		//声明实体类
		Student stu = new Student();
		//获取链接
		conn = DBUtils.getConnection();
		//创建SQL命令
		String sql = "select * from student where sid=? ";
		try {
			//创建Sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, str);
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
	 * 根据名称查询学生
	 * */
	@Override
	public Student getStudentInfo2(String str) {
		//声明JDBC变量
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		//声明实体类
		Student stu = new Student();
		//获取链接
		conn = DBUtils.getConnection();
		//创建SQL命令
		String sql = "select * from student where sname=?";
		try {
			//创建Sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, str);
		
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
	 * 根据登陆用户名查询老师
	 * */
	@Override
	public Teacher getTeacherInfo1(String str) {
		//声明JDBC变量
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		//声明实体类
		Teacher tea = new Teacher();
		//获取链接
		conn = DBUtils.getConnection();
		//创建SQL命令
		String sql = "select * from teacher where tid=?";
		try {
			//创建Sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, str);
			
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
	/**
	 * 根据名称查老师
	 * */
	@Override
	public Teacher getTeacherInfo2(String str) {
		//声明JDBC变量
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		//声明实体类
		Teacher tea = new Teacher();
		//获取链接
		conn = DBUtils.getConnection();
		//创建SQL命令
		String sql = "select * from teacher where	tname=?";
		try {
			//创建Sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, str);
			
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
	public List<Student> getStudents(int name, String searchText) {
		String sql = "select * from student where 1=1";
		if(name==1){
			sql += " and sid like '%"+searchText+"%'";
		}else if(name==2){
			sql += " and sname like '%"+searchText+"%'";
		}else{
			sql += " and rid ="+searchText;
		}
		PreparedStatement ps = null;		
		ResultSet rs =  null;
		List<Student> studentList = new ArrayList<Student>();
		// 1 获取连接对象
		Connection conn = DBUtils.getConnection();
		try {
			// 2 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 int sid2 = rs.getInt("sid");
				 String pwd = rs.getString("pwd");
				 int rid = rs.getInt("rid");
				 String sname = rs.getString("sname");
				 String sex = rs.getString("sex");
				 int age = rs.getInt("age");
				 String idcard = rs.getString("idcard");
				 Date birthdate = rs.getDate("birthdate");
				 String phone = rs.getString("phone");
				 String party = rs.getString("party");
				 String address = rs.getString("address");
				 String health = rs.getString("health");
				 int mid = rs.getInt("mid");
				 int cid2 = rs.getInt("cid");
				 int gcode = rs.getInt("gcode");
				 Date enterdate = rs.getDate("enterdate");
				 
				 Major major = new Major();
				 major.setMid(mid);
				 Classes classes = new Classes();
				 classes.setCid(cid2);
				 classes.setGrade(gcode);
				 classes.setMajor(major);
				 
				 Student student = new Student(sid2, pwd, rid, sname, sex, age, idcard, birthdate, party, phone, address, health, major, classes, gcode, enterdate);
				 studentList.add(student);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return studentList;
	}

	@Override
	public List<Teacher> getTeachers(int name, String searchText) {
		String sql = "select * from teacher where 1=1";
		if(name==1){
			sql += " and tid like '%"+searchText+"%'";
		}else if(name==2){
			sql += " and tname like '%"+searchText+"%'";
		}else{
			sql += " and rid ="+searchText;
		}
		System.out.println(sql);
		PreparedStatement ps = null;
		ResultSet rs =  null;
		List<Teacher> teacherList = new ArrayList<>();
		// 1 获取连接对象
		Connection conn = DBUtils.getConnection();
		try {
			// 2 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 int tid = rs.getInt("tid");
				 String pwd = rs.getString("pwd");
				 int rid = rs.getInt("rid");
				 int mid = rs.getInt("mid");
				 String tname = rs.getString("tname");
				 String sex = rs.getString("sex");
				 int age = rs.getInt("age");
				 String nation = rs.getString("nation");
				 String party = rs.getString("party");
				 String education = rs.getString("education");
				 String marry = rs.getString("marry");
				 Date birthdate = rs.getDate("birthdate");
				 String idcard = rs.getString("idcard");
				 String phone = rs.getString("phone");
				 Date hiredate = rs.getDate("hiredate");
				 String desc = rs.getString("desc");
				 
				 Major major = new Major();
				 major.setMid(mid);
				 Teacher teahcer = new Teacher(tid, pwd, rid, major, tname, sex, age, nation, party, education, marry, birthdate, idcard, phone, hiredate, desc);
				 teacherList.add(teahcer);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return teacherList;
	}

	@Override
	public int updateStudentPwd(int id, String pwd) {
		String sql = "update student set pwd=? where sid=?";
		return DBUtils.executeDML(sql, pwd, id);
	}

	@Override
	public int updateTeacherPwd(int id, String pwd) {
		String sql = "update teacher set pwd=? where tid=?";
		return DBUtils.executeDML(sql, pwd, id);
	}

}
