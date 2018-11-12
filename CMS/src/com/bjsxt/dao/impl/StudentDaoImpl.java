package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.StudentDao;
import com.bjsxt.pojo.Classes;
import com.bjsxt.pojo.Major;
import com.bjsxt.pojo.Student;
import com.bjsxt.util.DBUtils;

public class StudentDaoImpl implements StudentDao{

	/**
	 * 查询所有班级信息
	 */
	@Override
	public List<Classes> getAllClasses() {
		String sql = "select * from classes";		
		PreparedStatement ps = null;
		ResultSet rs =  null;
		List<Classes> classesList = new ArrayList<>();
		
		// 1 获取连接对象
		Connection conn = DBUtils.getConnection();

		try {
			// 2 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 int cid = rs.getInt("cid");
				 int grade = rs.getInt("grade");
				 String cname = rs.getString("cname");
				 int mid = rs.getInt("mid");
				 
				 Major major = new Major();
				 major.setMid(mid);
				 
				 Classes classes = new Classes(cid, grade, major, cname);				 
				 classesList.add(classes);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return classesList;
	}

	/**
	 * 根据mid查询major信息
	 */
	@Override
	public Major getMajorByMid(int mid) {
		String sql = "select * from major where mid=?";		
		PreparedStatement ps = null;
		ResultSet rs =  null;
		Major major = null;
		
		// 1 获取连接对象
		Connection conn = DBUtils.getConnection();

		try {
			// 2 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, mid);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 String mname = rs.getString("mname");
				 major = new Major(mid, mname);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return major;
	}

	/**
	 * 根据sid查询学生信息
	 */
	@Override
	public Student getMyInfoBySid(int sid) {
		String sql = "select * from student where sid=?";		
		PreparedStatement ps = null;
		ResultSet rs =  null;
		Student student = null;
		
		// 1 获取连接对象
		Connection conn = DBUtils.getConnection();

		try {
			// 2 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, sid);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
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
				 int cid = rs.getInt("cid");
				 int gcode = rs.getInt("gcode");
				 Date enterdate = rs.getDate("enterdate");
				 
				 Major major = new Major();
				 major.setMid(mid);
				 Classes classes = new Classes();
				 classes.setCid(cid);
				 classes.setGrade(gcode);
				 classes.setMajor(major);
				 
				 student = new Student(sid, pwd, rid, sname, sex, age, idcard, birthdate, party, phone, address, health, major, classes, gcode, enterdate);
				 
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return student;
	}

	/**
	 * 根据cid查mid
	 */
	@Override
	public int getMidByCid(int cid) {
		String sql = "select mid from classes where cid=?";		
		PreparedStatement ps = null;
		ResultSet rs =  null;
		int mid = 0;
		// 1 获取连接对象
		Connection conn = DBUtils.getConnection();

		try {
			// 2 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, cid);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 mid = rs.getInt("mid");
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return mid;
	}
	
	/**
	 * 根据cid查cname
	 */
	@Override
	public String getCnameByCid(int cid) {
		String sql = "select cname from classes where cid=?";		
		PreparedStatement ps = null;
		ResultSet rs =  null;
		String cname = null;
		// 1 获取连接对象
		Connection conn = DBUtils.getConnection();

		try {
			// 2 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, cid);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 cname = rs.getString("cname");
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return cname;
	}
	
	/**
	 * 添加学生信息
	 * INSERT INTO student(pwd,sname,sex,age,idcard,birthdate,party,phone,address,health,rid,MID,gcode,cid,enterdate) VALUES('123456','qiao','男',21,'410305199702204011','1997-02-20','团员','15225507794','zg','优秀',1,4,3,3,'2015-09-01')
	 */
	@Override
	public int addStudent(Student student) {
		String sql = "insert into student(pwd,sname,sex,age,idcard,birthdate,party,phone,address,health,rid,MID,gcode,cid,enterdate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object obj[] = { student.getPwd(), student.getSname(), student.getSex(), student.getAge(),
						 student.getIdcard(), student.getBirthdate(), student.getParty(), student.getPhone(),
						 student.getAddress(), student.getHealth(), student.getRid(), student.getMajor().getMid(),
						 student.getGcode(), student.getClasses().getCid(), student.getEnterdate()
						 };
		return DBUtils.executeDML(sql, obj);
	}
	
	/**
	 * 获取查询总数
	 */
	@Override
	public int getCount(String sid, String cid) {
		String sql = "select count(*) from student where 1=1";
		if(!"".equals(sid)){
			sql += " and like '%"+sid+"%'";
		}
		if(!cid.equals("0")){
			sql += " and cid = "+cid;
		}
		PreparedStatement ps = null;
		ResultSet rs =  null;
		// 1 获取连接对象
		Connection conn = DBUtils.getConnection();

		try {
			// 2 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 if(rs.next()){
				 return rs.getInt(1);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return -1;
	}

	@Override
	public List<Student> getStudents(String sid, String cid, int pageStart,
			int pageSize) {
		String sql = "select * from student where 1=1";
		if(!"".equals(sid)){
			sql += " and sid like '%"+sid+"%'";
		}
		if(!cid.equals("0")){
			sql += " and cid = "+cid;
		}
		sql += " limit ?,?";
		PreparedStatement ps = null;		
		ResultSet rs =  null;
		List<Student> studentList = new ArrayList<Student>();
		// 1 获取连接对象
		Connection conn = DBUtils.getConnection();
		try {
			// 2 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, pageStart);
			 ps.setInt(2, pageSize);
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

	/**
	 * 修改学生信息
	 * UPDATE student SET cid=301201,MID=3,age=22,party='团员',phone='1008612580',address='地球',health='良好' WHERE sid=8888
	 */
	@Override
	public int updateStudent(Student student) {
		String sql ="UPDATE student SET cid=?,MID=?,age=?,party=?,phone=?,address=?,health=? WHERE sid=?";
		Object obj[] = { student.getClasses().getCid(), student.getMajor().getMid(), student.getAge(),
						 student.getParty(), student.getPhone(), student.getAddress(),
						 student.getHealth(), student.getSid()
					};
		return DBUtils.executeDML( sql, obj);
	}

	/**
	 * 根据cid查找年级
	 */
	@Override
	public int getGcodeByCid(int cid) {
		String sql = "select grade from classes where cid=?";		
		PreparedStatement ps = null;
		ResultSet rs =  null;
		int gcode = 0;
		// 1 获取连接对象
		Connection conn = DBUtils.getConnection();

		try {
			// 2 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, cid);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 gcode = rs.getInt("grade");
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return gcode;
	}

}
