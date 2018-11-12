package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.TeacherDao;
import com.bjsxt.pojo.Classes;
import com.bjsxt.pojo.MajClasses;
import com.bjsxt.pojo.Major;
import com.bjsxt.pojo.Subject;
import com.bjsxt.pojo.Teacher;
import com.bjsxt.pojo.TeacherBoss;
import com.bjsxt.pojo.TeacherSub;
import com.bjsxt.util.DBUtils;

public class TeacherDaoImpl implements TeacherDao{
	
	//乔
	/**
	 * 查找所有的专业信息
	 */
	@Override
	public List<Major> getMajor() {
		String sql = "select * from major";
		return DBUtils.executeSelect(sql, new Major());
	}
	
	/**
	 * 添加教师信息
	 * INSERT INTO teacher(pwd,rid,MID,tname,sex,age,nation,party,education,marry,birthdate,idcard,phone,hiredate,`desc`)VALUES('bjsxt',2,1,'马云2','男',50,'汉族','党员','专科','已婚','1960-11-11','1101201301101032','12580','1999-11-11','我最有钱')
	 */
	@Override
	public int addTeacher(Teacher teacher) {
		String sql = "INSERT INTO teacher(pwd,rid,MID,tname,sex,age,nation,party,education,marry,birthdate,idcard,phone,hiredate,`desc`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object obj[] = { teacher.getPwd(), teacher.getRid(), teacher.getMajor().getMid(), teacher.getTname(),
						 teacher.getSex(), teacher.getAge(), teacher.getNation(), teacher.getParty(),
						 teacher.getEducation(), teacher.getMarry(), teacher.getBirthdate(), teacher.getIdcard(),
						 teacher.getPhone(), teacher.getHiredate(), teacher.getDesc()
					   };
		return DBUtils.executeDML(sql, obj);
	}

	/**
	 * 查询符合条件的教师数量
	 */
	@Override
	public int getCount(int search, String searchText) {
		String sql = "select count(*) from teacher where 1=1";
		if(search==0){
			
		}else if(search==1){
			sql += " and tname like '%"+searchText+"%'";
		}else if(search==2){
			sql += " and tid like '%"+searchText+"%'";
		}else if(search==3){
			sql += " and idcard like '%"+searchText+"%'";
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

	/**
	 * 按条件分页查询老师的信息
	 */
	@Override
	public List<Teacher> getTeachers(int search, String searchText,
			int pageStart, int pageSize) {
		String sql = "select * from teacher where 1=1";
		if(search==0){
			
		}else if(search==1){
			sql += " and tname like '%"+searchText+"%'";
		}else if(search==2){
			sql += " and tid like '%"+searchText+"%'";
		}else if(search==3){ 
			sql += " and idcard like '%"+searchText+"%'";
		}
		sql += " limit ?,?";
		PreparedStatement ps = null;
		ResultSet rs =  null;
		List<Teacher> teacherList = new ArrayList<>();
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

	
	/**
	 * 根据tid查找某老师的信息
	 */
	@Override
	public Teacher getTeacherByTid1(int tid) {
		String sql = "select * from teacher where tid=?";
		PreparedStatement ps = null;
		ResultSet rs =  null;
		Teacher teacher = null;
		// 1 获取连接对象
		Connection conn = DBUtils.getConnection();
		try {
			// 2 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, tid);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 if(rs.next()){
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
				 teacher = new Teacher(tid, pwd, rid, major, tname, sex, age, nation, party, education, marry, birthdate, idcard, phone, hiredate, desc);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return teacher;
	}

	/**
	 * 根据Mid查找Mname
	 */
	@Override
	public String getMnameByMid(int mid) {
		String sql = "select mname from major where mid=?";
		PreparedStatement ps = null;
		ResultSet rs =  null;
		String mname = null;
		// 1 获取连接对象
		Connection conn = DBUtils.getConnection();
		try {
			// 2 创建预处理块对象
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mid);
			// 3 执行sql语句 ，返回结果
			rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			if(rs.next()){
				mname = rs.getString("mname");
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return mname;
	}

	/**
	 * 修改老师信息
	 * UPDATE teacher SET age=31,marry='未婚',party='群众',education='本科',phone='12580',MID=2,`desc`='6666666' WHERE tid=12345
	 */
	@Override
	public int updateTeacher(Teacher teacher) {
		String sql = "UPDATE teacher SET age=?,marry=?,party=?,education=?,phone=?,MID=?,`desc`=? WHERE tid=?";
		Object obj[] = { teacher.getAge(), teacher.getMarry(), teacher.getParty(),
						 teacher.getEducation(), teacher.getPhone(), teacher.getMajor().getMid(),
						 teacher.getDesc(), teacher.getTid()
		};
		return DBUtils.executeDML(sql, obj);
	}

	@Override
	public List<Object> thinkFind(int search, String searchText) {
		String sql = null;	
		int flag = -1;
		if(search==0){
			sql = "select * from teacher where ";
			flag = 0;
		}else if(search==1){
			sql = "select tname from teacher where tname like '%"+searchText+"%' limit 0,7";
			flag = 1;
		}else if(search==2){
			sql = "select tid from teacher where tid like '%"+searchText+"%' limit 0,7";
			flag = 2;
		}else{
			sql = "select idcard from teacher where idcard like '%"+searchText+"%' limit 0,7";
			flag = 3;
		}
		PreparedStatement ps = null;
		ResultSet rs =  null;
		List<Object> list = new ArrayList<>();
		// 1 获取连接对象
		Connection conn = DBUtils.getConnection();
		try {
			// 2 创建预处理块对象
			 ps = conn.prepareStatement(sql);
			// 3 执行sql语句 ，返回结果
			 rs = ps.executeQuery();
			// 4 遍历结果集  ， 将数据放到对象中， 放到list中
			 while(rs.next()){
				 Object obj = null;
				 if(flag==1){
					 obj = rs.getObject("tname");
				 }else if(flag==2){
					 obj = rs.getObject("tid");
				 }else if(flag==3){
					 obj = rs.getObject("idcard");
				 }
				 list.add(obj);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// 5 释放资源
			DBUtils.closeAll(rs, ps, conn);
		}
		return list;
	}
	
	//耗子
	
	/**
	 * 遍历科目(任课科目下拉框)
	 * 	请求转发到 staff/teachCurriculum.jsp页面
	 * @param req
	 * @param resp
	 */
	@Override
	public List<Subject> teacherSubList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Subject > tsList = new ArrayList<Subject>();
		
		try {
			String sql = "select * from subject where subid <> 0";
			
			conn = DBUtils.getConnection();
			ps = DBUtils.getPreparedStatement(conn, sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Subject sb = new Subject();
				sb.setSubid(rs.getInt("subid"));
				sb.setSubname(rs.getString("subname"));
				sb.setExamtype(rs.getString("examtype"));
				sb.setExamdate(rs.getDate("examdate"));
				tsList.add(sb);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return tsList;
	}

	/**
	 * 三条件查询教师(任课科目，教师编号，任职日期)
	 * 查询字段(教师姓名，性别，年龄，学历，授课专业，结婚状态)
	 * 分页查询
	 * @return
	 */
	@Override
	public List<Teacher> teacherSubJectsBySTH(String sname, int tid, String hiredate , int  pageStart , int pageSize) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Teacher > tcList = new ArrayList<Teacher>();
		
		try {
			String sql = "select t.tname , t.sex , t.age , t.education , m.mname ,  t.marry "
								+"from assign a "
								+"inner join subject s "
								+"on a.subid = s.subid "
								+"inner join teacher t "
								+"on t.tid = a.tid "
								+"inner join major m "
								+"on m.mid = t.mid "
								// 搜索条件
								+"where t.tid like ?  "  //教师编号  1
								+"and s.subname like ? "  //任课科目  Java
								+"and DATE_FORMAT(a.hiredate,'%Y%m%d') like ?  " //任职日期20181019
								+"limit ? , ?";  
			
			conn = DBUtils.getConnection();
			ps = DBUtils.getPreparedStatement(conn, sql);
			
			if(tid == 0 && hiredate != null){
				ps.setString(1 , "%%");
				ps.setString(2 , sname);
				ps.setString(3, hiredate);
			}
			if(hiredate == null && tid != 0){
				ps.setInt(1 , tid);
				ps.setString(2 , sname);
				ps.setString(3, "%%");
			}
			if(hiredate == null && tid == 0){
				ps.setString(1 , "%%");
				ps.setString(2 , sname);
				ps.setString(3, "%%");
			}
			if(hiredate != null && tid != 0){
				ps.setInt(1 , tid);
				ps.setString(2 , sname);
				ps.setString(3, hiredate);
			}
			
			ps.setInt(4, pageStart);
			ps.setInt(5, pageSize);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				Teacher t = new Teacher();
				
				t.setTname(rs.getString("tname"));
				t.setSex(rs.getString("sex"));
				t.setAge(rs.getInt("age"));
				t.setEducation(rs.getString("education"));
				
				Major m = new Major();
				m.setMname(rs.getString("mname"));
				
				t.setMajor(m);
				t.setMarry(rs.getString("marry"));
				
				tcList.add(t);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return tcList;
	}

	
	/**
	 * 统计总页数
	 * @param sname
	 * @param tid
	 * @param hiredate
	 * @return
	 */
	@Override
	public int teacherCountBySTH(String sname, int tid, String hiredate) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(*) "
								+"from assign a "
								+"inner join subject s "
								+"on a.subid = s.subid "
								+"inner join teacher t "
								+"on t.tid = a.tid "
								+"inner join major m "
								+"on m.mid = t.mid "
								// 搜索条件
								+"where t.tid like ?  "  //教师编号  12345
								+"and s.subname = ? "  //任课科目  Java
								+"and DATE_FORMAT(a.hiredate,'%Y%m%d') like ? ";  //任职日期20181019
			
			conn = DBUtils.getConnection();
			ps = DBUtils.getPreparedStatement(conn, sql);
			
			if(tid == 0 && hiredate != null){
				ps.setString(1 , "%%");
				ps.setString(2 , sname);
				ps.setString(3, hiredate);
			}
			if(hiredate == null && tid != 0){
				ps.setInt(1 , tid);
				ps.setString(2 , sname);
				ps.setString(3, "%%");
			}
			if(hiredate == null && tid == 0){
				ps.setString(1 , "%%");
				ps.setString(2 , sname);
				ps.setString(3, "%%");
			}
			if(hiredate != null && tid != 0){
				ps.setInt(1 , tid);
				ps.setString(2 , sname);
				ps.setString(3, hiredate);
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				return rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return -1;
	}

	/**
	 * 获得所有班级信息、专业信息、年级信息
	 * 功能 	: 遍历班级(班级下拉框)
	 * @return
	 */
	@Override
	public List<Classes> teacherClasses() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Classes > csList = new ArrayList<Classes>();
		
		try {
			String sql = "select * from classes c "+
								"inner join major m "+
								"on c.mid = m.mid ";
			
			conn = DBUtils.getConnection();
			ps = DBUtils.getPreparedStatement(conn, sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				//创建班级对象
				Classes cs = new Classes();
				
				cs.setCid(rs.getInt("cid"));
				cs.setGrade(rs.getInt("grade"));
				
				Major m = new Major();
				m.setMid(rs.getInt("mid"));
				m.setMname(rs.getString("mname"));
				cs.setMajor(m);
				
				cs.setCname(rs.getString("cname"));
				
				csList.add(cs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return csList;
	}

	/**
	 * 获得所有班级信息、专业信息、年级信息
	 * 功能 	: 遍历班级(通过班级下拉框选择查询)
	 * 		 	: 通过班级cid查询到对应专业
	 * 			: 通过班级cid查询到对应年级
	 * @return
	 */
	@Override
	public MajClasses getMajClassesByCid(int cid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//创建实体类
		MajClasses mc = new MajClasses();
		//将当前cid放入
		mc.setCid(cid);
		
		if(cid == 0){  //如果是0直接返回一个空对象
			return mc;
		}
		
		try {
			String sql = "select * from classes c "+
								"inner join major m "+
								"on c.mid = m.mid "+
								"where c.cid = ? ";
			
			conn = DBUtils.getConnection();
			ps = DBUtils.getPreparedStatement(conn, sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			
			while(rs.next()){
				mc.setGrade(rs.getInt("grade") + "年级");
				mc.setMid(rs.getInt("mid"));
				mc.setCname(rs.getString("cname"));
				mc.setMname(rs.getString("mname"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return mc;
	}

	/**
	 * 获取教师信息
	 * 通过tid(教师ID)
	 * @param tid
	 * @return
	 */
	@Override
	public Teacher getTeacherByTid(int tid) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//创建Teacher对象
		Teacher t = new Teacher();
		if(tid == 0){
			return t;
		}
		
		try {
			String sql = "select t.tname , t.sex , t.age , t.education , m.mname ,  t.marry "+
								"from teacher t "+
								"inner join major m "+
								"on m.mid = t.mid "+
								"where t.tid = ? ";
			
			conn = DBUtils.getConnection();
			ps = DBUtils.getPreparedStatement(conn, sql);
			ps.setInt(1, tid);
			rs = ps.executeQuery();
			
			while(rs.next()){
				t.setTname(rs.getString("tname"));
				t.setSex(rs.getString("sex"));
				t.setAge(rs.getInt("age"));
				t.setEducation(rs.getString("education"));
				
				Major m = new Major();
				m.setMname(rs.getString("mname"));
				t.setMajor(m);
				
				t.setMarry(rs.getString("marry"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return t;
	}

	/**
	 * 将老师变成班主任
	 * 修改assign表中cid字段，更换老师任课班级
	 * 修改teacher中hiredate(任职时间)、desc(职位)
	 * 老师班级专业信息会随之改变(外键关系)
	 * 通过tid找到老师
	 * @param tid
	 * @return
	 */
	@Override
	public int updTeacherToBossByTid(int tid , String hiredate , int cid) {
		
		System.out.println("cid = " +cid);
		
		//查询出要修改为的mid
		int mid = getMajClassesByCid(cid).getMid();
		System.out.println("mid = " + mid);
		
		String sql1 = " update teacher set hiredate = ? , `desc` =  ?  ,  mid = ? "+
							" where tid = ?   ";
		
		String sql2 = "update assign set cid = ?  "+
							"where tid = ?   ";
		
		System.out.println("tid : " + tid);
		
		int num1 = DBUtils.executeDML(sql1, hiredate , "班主任" , mid , tid);
		int num2 = DBUtils.executeDML(sql2, cid , tid);
		
		System.out.println("num1 : "  + num1 +"  num2 : " + num2);
		
		if(num1 > 0 && num2 >0){
			return 1;
		}
		
		return -1;
	}

	/**
	 * 根据教师名称查询
	 * 教师编号、教师姓名、教师性别、任职日期、任职科目
	 * 涉及表 : teacher(教师表)、assign(教师任职任课表)、subject(课程表)
	 * @param name 教师姓名
	 * @return
	 */
	@Override
	public List<TeacherSub> getTeacherSubListByTeacherName(String name) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TeacherSub> tsList = new ArrayList<TeacherSub>();
		
		try {
			String sql = "select t.tid , t.tname , t.sex , a.hiredate , s.subname  "+
								"from teacher t  "+
								"inner join assign a "+
								"on t.tid = a.tid "+
								"inner join subject s "+
								"on s.subid = a.subid "+
								"where t.tname like ?  ";
			
			conn = DBUtils.getConnection();
			ps = DBUtils.getPreparedStatement(conn, sql);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			
			while(rs.next()){
				//创建Teacher对象
				TeacherSub ts = new TeacherSub();
				ts.setTid(rs.getInt("tid"));
				ts.setName(rs.getString("tname"));
				ts.setSex(rs.getString("sex"));
				
				ts.setHiredate(rs.getString("hiredate"));
				
				ts.setSubname(rs.getString("subname"));
				tsList.add(ts);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return tsList;
	}

	@Override
	public List<TeacherSub> getTeacherSubListBySubname(String subname) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TeacherSub> tsList = new ArrayList<TeacherSub>();
		
		try {
			String sql = "select t.tid , t.tname , t.sex , a.hiredate , s.subname  "+
								"from teacher t  "+
								"inner join assign a "+
								"on t.tid = a.tid "+
								"inner join subject s "+
								"on s.subid = a.subid "+
								"where s.subname like ?  ";
			
			conn = DBUtils.getConnection();
			ps = DBUtils.getPreparedStatement(conn, sql);
			ps.setString(1, "%" + subname + "%");
			rs = ps.executeQuery();
			
			while(rs.next()){
				//创建Teacher对象
				TeacherSub ts = new TeacherSub();
				ts.setTid(rs.getInt("tid"));
				ts.setName(rs.getString("tname"));
				ts.setSex(rs.getString("sex"));
				
				ts.setHiredate(rs.getString("hiredate"));
				
				ts.setSubname(rs.getString("subname"));
				tsList.add(ts);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return tsList;
	}

	/**
	 * 根据教师ID将教师离职
	 * @param tid
	 * @return
	 */
	@Override
	public int leaveOfficeTeacherDao(int tid) {
		String sql = "update assign set subid = 0  "+
							"where tid = ? ";
		return DBUtils.executeDML(sql, tid);
	}

	/**
	 * 查询所有班主任信息
	 * 教师编号、教师姓名、教师性别、任课课程、年级、专业名称
	 * 通过班级名称、年级、专业名称
	 * @return
	 */
	@Override
	public List<TeacherBoss> teacherBossListByGCMN(int grade, String cname,
			String mname , int num) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TeacherBoss> tbList = new ArrayList<TeacherBoss>();
		
		try {
			String sql = "select t.tid , t.tname , t.sex , c.cname , c.grade , m.mname , a.hiredate "+
								"from teacher t "+
								"inner join classes c  "+
								"on c.mid = t.mid "+
								"inner join major m "+
								"on m.mid = c.mid "+
								"inner join assign a "+
								"on t.tid = a.tid "+
								"where c.grade like ? "+
								"and c.cname like ? "+
								"and m.mname like ? "+
								"and t.desc = '班主任' "+
								"and a.subid != 0"; 
			
			conn = DBUtils.getConnection();
			ps = DBUtils.getPreparedStatement(conn, sql);
			
			switch (num) {
			
			case 1 :
				if(grade == 0){
					ps.setString(1 , "%%");
				}else{
					ps.setString(1,"%"+grade+"%");
				}
				ps.setString(2 , "%%");
				ps.setString(3 , "%%");
				break;
			case 2:
				ps.setString(1 , "%%");
				ps.setString(2 , "%" + cname + "%");
				ps.setString(3 , "%%");
				break;
			case 3 :
				ps.setString(1 , "%%");
				ps.setString(2 , "%%");
				ps.setString(3 , "%" + mname + "%");
				break;
			default:
				
				break;
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				//创建Teacher对象
				TeacherBoss tb = new TeacherBoss();
				tb.setTid(rs.getInt("tid"));
				tb.setTname(rs.getString("tname"));
				tb.setSex(rs.getString("sex"));
				tb.setCname(rs.getString("cname"));
				tb.setGrade(rs.getInt("grade"));
				tb.setMname(rs.getString("mname"));
				tb.setHiredate(rs.getString("hiredate"));
				tbList.add(tb);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return tbList;
	}


}
