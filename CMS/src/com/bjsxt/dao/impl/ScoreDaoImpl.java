package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.ScoreDao;
import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.Subject;
import com.bjsxt.util.DBUtils;
import com.bjsxt.vo.ScoreVo;
import com.bjsxt.vo.StudentScoreVo;

/**
 * 成绩管理
 * @author 997
 *
 */
public class ScoreDaoImpl implements ScoreDao {

	@Override
	public List<Subject> getSubjectByTid(int tid) {
		//定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		List<Subject> subjectList = new ArrayList<Subject>();

		try {
			// 1 获取连接对象
			conn = DBUtils.getConnection();
			// 2 创建sql
			String sql = " select sub.subid, sub.subname from `subject` sub "+
					" inner join assign a "+
					" on sub.subid = a.subid "+
					" where a.tid = ? and sub.subid != 0";
			// 3 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			 //给占位符赋值
			 ps.setInt(1, tid);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 String subname = rs.getString("subname");
				 int subid = rs.getInt("subid");
				 
				 Subject subject = new Subject();
				 subject.setSubname(subname);
				 subject.setSubid(subid);
				 subjectList.add(subject);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return subjectList;
	}

	@Override
	public List<Student> getStudentBySubid(int subid, int tid) {
		//定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		List<Student> studentList = new ArrayList<Student>();

		try {
			// 1 获取连接对象
			conn = DBUtils.getConnection();
			// 2 创建sql
			String sql = " select stu.sid, stu.sname from choose ch "
						+" inner join student stu "
						+" on stu.sid = ch.sid "
						+" where ch.subid = ? AND ch.tid = ? ";
			// 3 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			 //给占位符赋值
			 ps.setInt(1, subid);
			 ps.setInt(2, tid);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 String sname = rs.getString("sname");
				 int sid = rs.getInt("sid");
				 
				 Student student = new Student();
				 student.setSname(sname);
				 student.setSid(sid);
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
	public int updateScoreByid(int sid, int subid, int score) {
			String sql = "update choose set score = ? where subid = ? and sid = ?";
			return DBUtils.executeDML(sql, score, subid, sid);
	}

	@Override
	public List<StudentScoreVo> pageQuery(int pageStart, int pageSize) {
		//定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		List<StudentScoreVo> ssList = new ArrayList<StudentScoreVo>();

		try {
			// 1 获取连接对象
			conn = DBUtils.getConnection();
			// 2 创建sql
			String sql = " select s.sid, s.sname, c.grade, c.cname, sub.subname, "
						+ "t.tname, ch.score from choose ch"
						+" inner join `subject` sub "
						+" on sub.subid = ch.subid "
						+" inner join student s           "
						+" on s.sid = ch.sid              "
						+" inner join classes c           "
						+" on s.cid = c.cid               "
						+" inner join teacher t           "
						+" on t.tid = ch.tid LIMIT ?, ? ";
			// 3 创建预处理块对象                         "
			 ps = conn.prepareStatement(sql);              
			 //给占位符赋值
			 ps.setInt(1, pageStart);
			 ps.setInt(2, pageSize);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 int sid = rs.getInt("sid");
				 String sname = rs.getString("sname");
				 int grade = rs.getInt("grade");
				 String cname = rs.getString("cname");
				 String subname = rs.getString("subname");
				 String tname = rs.getString("tname");
				 double score = rs.getDouble("score");
				 
				 StudentScoreVo studentScoreVo = new StudentScoreVo(sid, sname, grade, cname, subname, tname, score);
				 ssList.add(studentScoreVo);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return ssList;
	}

	@Override
	public List<StudentScoreVo> pageQueryByArgs(int pageStart, int pageSize, int type, String cond) {
		//定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		List<StudentScoreVo> ssList = new ArrayList<StudentScoreVo>();

		try {
			// 1 获取连接对象
			conn = DBUtils.getConnection();
			// 2 创建sql
			String sql = " select s.sid, s.sname, c.grade, c.cname, sub.subname, "
						+ "t.tname, ch.score from choose ch"
						+" inner join `subject` sub "
						+" on sub.subid = ch.subid "
						+" inner join student s           "
						+" on s.sid = ch.sid              "
						+" inner join classes c           "
						+" on s.cid = c.cid               "
						+" inner join teacher t           "
						+" on t.tid = ch.tid ";
			
			if(!"".equals(cond) && cond != null){
				if (type == 1) {
					sql += " where s.sname = ?";
				} else if(type == 2){
					sql += " where sub.subname= ?";
				}
			}
			sql += "LIMIT ?, ? ";
			
			// 3 创建预处理块对象                        
			 ps = conn.prepareStatement(sql);              
			 //给占位符赋值
			 if(!"".equals(cond) && cond != null){
				 ps.setString(1, cond);
				 ps.setInt(2, pageStart);
				 ps.setInt(3, pageSize);
			 }else{
				 ps.setInt(1, pageStart);
				 ps.setInt(2, pageSize);
			 }
			 
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 int sid = rs.getInt("sid");
				 String sname = rs.getString("sname");
				 int grade = rs.getInt("grade");
				 String cname = rs.getString("cname");
				 String subname = rs.getString("subname");
				 String tname = rs.getString("tname");
				 double score = rs.getDouble("score");
				 
				 StudentScoreVo studentScoreVo = new StudentScoreVo(sid, sname, grade, cname, subname, tname, score);
				 ssList.add(studentScoreVo);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return ssList;
	}

	@Override
	public List<ScoreVo> getScoreByClasses(int cid) {
		//定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		List<ScoreVo> svList = new ArrayList<ScoreVo>();

		try {
			// 1 获取连接对象
			conn = DBUtils.getConnection();
			// 2 创建sql
			String sql = " select sub.subid,sub.subname,avg(ch.score) avg from `subject` sub"
					+" inner join choose ch             "
					+" on ch.subid = sub.subid          "
					+" inner join student s             "
					+" on s.sid = ch.sid                "
					+" inner join classes c             "
					+" on c.cid = s.cid                 "
					+" where c.cid = ?             "
					+" group by sub.subid, sub.subname ";
			// 3 创建预处理块对象                       
			 ps = conn.prepareStatement(sql);              
			 //给占位符赋值
			 ps.setInt(1, cid);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 String subname = rs.getString("subname");
				 double avg = rs.getDouble("avg");
				 
				 ScoreVo scoreVo = new ScoreVo(subname, avg);
				 svList.add(scoreVo);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return svList;
	}

	@Override
	public int getScoreByGrade(int gid, int min, int max) {
		//定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			// 1 获取连接对象
			conn = DBUtils.getConnection();
			// 2 创建sql
			String sql = " select count(*) count from `subject` sub"
						+" inner join choose ch    "
						+" on ch.subid = sub.subid "
						+" inner join student s    "
						+" on s.sid = ch.sid       "
						+" inner join classes c    "
						+" on c.cid = s.cid        "
						+" where s.gcode = ? and ch.subid = 1 and ch.score >= ? and ch.score < ? ";
			// 3 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			 //给占位符赋值
			 ps.setInt(1, gid);
			 ps.setInt(2, min);
			 ps.setInt(3, max);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 return rs.getInt("count");
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
	public int getpageCount() {
		//定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			// 1 获取连接对象
			conn = DBUtils.getConnection();
			// 2 创建sql
			String sql = " select count(*) count from choose";
			// 3 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 return rs.getInt("count");
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
	public List<Subject> beforefindScoreByGrade(int gid) {
		//定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		List<Subject> subList = new ArrayList<Subject>();
		try {
			// 1 获取连接对象
			conn = DBUtils.getConnection();
			// 2 创建sql
			String sql = "select DISTINCT sub.subid, sub.subname from `subject` sub"
						+" inner join choose ch   "
						+" on ch.subid = sub.subid"
						+" inner join student s   "
						+" on s.sid = ch.sid      "
						+" where s.gcode = ?    ";
			// 3 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, gid);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 String subname = rs.getString("subname");
				 int subid = rs.getInt("subid");
				 Subject sub = new Subject();
				 sub.setSubid(subid);
				 sub.setSubname(subname);
				 subList.add(sub);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return subList;
	}

	@Override
	public int getpageCountBySid(int sid) {
		//定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			// 1 获取连接对象
			conn = DBUtils.getConnection();
			// 2 创建sql
			String sql = " select count(*) count from choose where sid = ?";
			// 3 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			//给占位符赋值
			 ps.setInt(1, sid);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 return rs.getInt("count");
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
	public List<StudentScoreVo> pageQueryBySid(int pageStart, int pageSize, int sid) {
		//定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		List<StudentScoreVo> ssList = new ArrayList<StudentScoreVo>();

		try {
			// 1 获取连接对象
			conn = DBUtils.getConnection();
			// 2 创建sql
			String sql = " select s.sid, s.sname, c.grade, c.cname, sub.subname, "
						+ "t.tname, ch.score from choose ch"
						+" inner join `subject` sub "
						+" on sub.subid = ch.subid "
						+" inner join student s           "
						+" on s.sid = ch.sid              "
						+" inner join classes c           "
						+" on s.cid = c.cid               "
						+" inner join teacher t           "
						+" on t.tid = ch.tid "
						+" where s.sid = ? "
						+ "LIMIT ?, ? ";
			// 3 创建预处理块对象                         
			 ps = conn.prepareStatement(sql);              
			 //给占位符赋值
			 ps.setInt(1, sid);
			 ps.setInt(2, pageStart);
			 ps.setInt(3, pageSize);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 int sid2 = rs.getInt("sid");
				 String sname = rs.getString("sname");
				 int grade = rs.getInt("grade");
				 String cname = rs.getString("cname");
				 String subname = rs.getString("subname");
				 String tname = rs.getString("tname");
				 double score = rs.getDouble("score");
				 
				 StudentScoreVo studentScoreVo = new StudentScoreVo(sid2, sname, grade, cname, subname, tname, score);
				 ssList.add(studentScoreVo);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return ssList;
	}

	@Override
	public int getpageCountBySid(Integer sid, String cond) {
		//定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			// 1 获取连接对象
			conn = DBUtils.getConnection();
			// 2 创建sql
			String sql = " select count(*) count from choose  ch"
						+" inner join `subject` sub"
						+" on ch.subid = sub.subid "
						+" where ch.sid = ? ";
			if(!"".equals(cond) && cond != null){
				sql += "and sub.subname = ?";
			}
			// 3 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			//给占位符赋值
			 ps.setInt(1, sid);
			 if(!"".equals(cond) && cond != null){
				 ps.setString(2, cond);
			 }
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 return rs.getInt("count");
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
	public List<StudentScoreVo> pageQueryBySidArgs(int pageStart, int pageSize,
			Integer sid, String cond) {
		//定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		List<StudentScoreVo> ssList = new ArrayList<StudentScoreVo>();

		try {
			// 1 获取连接对象
			conn = DBUtils.getConnection();
			// 2 创建sql
			String sql = " select s.sid, s.sname, c.grade, c.cname, sub.subname, "
						+ "t.tname, ch.score from choose ch"
						+" inner join `subject` sub "
						+" on sub.subid = ch.subid "
						+" inner join student s           "
						+" on s.sid = ch.sid              "
						+" inner join classes c           "
						+" on s.cid = c.cid               "
						+" inner join teacher t           "
						+" on t.tid = ch.tid "
						+" where s.sid = ? ";
			
			if(!"".equals(cond) && cond != null){
				sql += " and sub.subname = ? ";
			}
			sql += "LIMIT ?, ?";
			
			// 3 创建预处理块对象                         
			 ps = conn.prepareStatement(sql);              
			 //给占位符赋值
			 ps.setInt(1, sid);
			 if(!"".equals(cond) && cond != null){
				 ps.setString(2, cond);
				 ps.setInt(3, pageStart);
				 ps.setInt(4, pageSize);
			 }else{
				 ps.setInt(2, pageStart);
				 ps.setInt(3, pageSize);
			 }
			 
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 int sid2 = rs.getInt("sid");
				 String sname = rs.getString("sname");
				 int grade = rs.getInt("grade");
				 String cname = rs.getString("cname");
				 String subname = rs.getString("subname");
				 String tname = rs.getString("tname");
				 double score = rs.getDouble("score");
				 
				 StudentScoreVo studentScoreVo = new StudentScoreVo(sid2, sname, grade, cname, subname, tname, score);
				 ssList.add(studentScoreVo);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return ssList;
	}

	@Override
	public int getpageCount(int type, String cond) {
		//定义jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		try {
			// 1 获取连接对象
			conn = DBUtils.getConnection();
			// 2 创建sql
			String sql =  " select count(*) count from choose  ch " ;
			
			if(!"".equals(cond) && cond != null){
				if (type == 1) {
					sql += " inner join student s "
							+" on s.sid = ch.sid "
							+" where s.sname = ?";
				} else if(type == 2){
					sql += " inner join `subject` sub"
							+" on ch.subid = sub.subid "
							+" where sub.subname= ?";
				}
			}
			
			// 3 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			 if(!"".equals(cond) && cond != null){
				 ps.setString(1, cond);
			 }
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 return rs.getInt("count");
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return -1;
	}


}
