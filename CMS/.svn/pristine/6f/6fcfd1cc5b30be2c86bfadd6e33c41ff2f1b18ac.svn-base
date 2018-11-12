package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.TeacherDao;
import com.bjsxt.dao.impl.TeacherDaoImpl;
import com.bjsxt.pojo.Classes;
import com.bjsxt.pojo.MajClasses;
import com.bjsxt.pojo.Major;
import com.bjsxt.pojo.Subject;
import com.bjsxt.pojo.Teacher;
import com.bjsxt.pojo.TeacherBoss;
import com.bjsxt.pojo.TeacherPage;
import com.bjsxt.pojo.TeacherSub;
import com.bjsxt.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{

	//乔
	
	TeacherDao td = new TeacherDaoImpl();
	
	/**
	 * 查找所有的major信息
	 */
	@Override
	public List<Major> findMajor() {
		return td.getMajor();
	}

	/**
	 * 添加老师信息
	 */
	@Override
	public int addTeacher(Teacher teacher) {
		return td.addTeacher(teacher);
	}
	
	/**
	 * 按条件分页查询教师信息
	 */
	@Override
	public TeacherPage findTeachers(int search, String searchText, int num,
			int pageSize) {
		//将查询页码转换为起始查询行号
		int pageStart = num*pageSize-pageSize;
		//获取总的数据量
		int count = td.getCount(search,searchText);
		//获取总的分页数量
		int pages = (int) Math.ceil(count*1.0/pageSize);
		//获取分页数据
		List<Teacher> ls= td.getTeachers(search,searchText,pageStart,pageSize);
		for(Teacher t:ls){
			String mname = td.getMnameByMid(t.getMajor().getMid());
			t.getMajor().setMname(mname);
		}
		//创建Page对象封装分页查询相关的所有数据，便于响应。
		TeacherPage sp=new TeacherPage(num, pageSize, ls, pages, count);
		return sp;
	}

	/**
	 * 根据tid查找老师信息
	 */
	@Override
	public Teacher findTeacherByTid1(int tid) {
		Teacher teacher = td.getTeacherByTid1(tid);
		String mname = td.getMnameByMid(teacher.getMajor().getMid());
		teacher.getMajor().setMname(mname);
		return teacher;
	}

	/**
	 * 根据mid查找Mname
	 */
	@Override
	public String findMnameByMid(int mid) {
		return td.getMnameByMid(mid);
	}


	/**
	 * 修改老师信息
	 */
	@Override
	public int updateTeacher(Teacher teacher) {
		return td.updateTeacher(teacher);
	}

	/**
	 * 查找当前登录老师的信息
	 */
	@Override
	public Teacher findMyInfoByTid(Integer tid) {
		return td.getTeacherByTid1(tid);
	}

	/**
	 * 通过ajax实现联想查询
	 */
	@Override
	public List<Object> thinkFind(int search, String searchText) {
		return td.thinkFind(search,searchText);
	}
	
	//耗子
	
	
	/**
	 * 获取TeacherList
	 * 功能 : 遍历科目(任课科目下拉框)
	 */
	@Override
	public List<Subject> findTeacherSub() {
		return td.teacherSubList();
	}

	/**
	 * 三条件查询教师(任课科目，教师编号，任职日期)
	 * 查询字段(教师姓名，性别，年龄，学历，授课专业，结婚状态)
	 * 分页查询
	 * @return
	 */
	@Override
	public TeacherPage findTeacherBySTH(String sname , int tid , String hiredate , int num , int pageSize) {
		
		//将查询页码转换为起始查询行号
			int pageStart = num*pageSize-pageSize;   //0
			
		//获取总的数据量
			int count = td.teacherCountBySTH(sname, tid, hiredate);
			
		//获取总的分页数量
			int pages=(int) Math.ceil(count*1.0/pageSize);
			
		//获取分页数据
			List<Teacher> ls= td.teacherSubJectsBySTH(sname, tid, hiredate, pageStart, pageSize);
			
		//创建Page对象封装分页查询相关的所有数据，便于响应。
			TeacherPage tp=new TeacherPage();
			
			tp.setNum(num);
			tp.setPageSize(pageSize);
			tp.setTs(ls);
			tp.setPages(pages);
			tp.setCount(count);
			
		return tp;
		
	}

	/**
	 * 获得所有班级信息
	 * 功能 : 遍历班级(班级下拉框)
	 * @return
	 */
	@Override
	public List<Classes> findTeacherClasses() {
		return td.teacherClasses();
	}

	/**
	 * 获得所有班级信息、专业信息、年级信息
	 * 功能 	: 遍历班级(通过班级下拉框选择查询)
	 * 		 	: 通过班级cid查询到对应专业
	 * 			: 通过班级cid查询到对应年级
	 * @return
	 */
	@Override
	public MajClasses findMajClassByCid(int cid) {
		return td.getMajClassesByCid(cid);
	}

	/**
	 * 获取教师信息
	 * 通过tid(教师ID)
	 * @param tid
	 * @return
	 */
	@Override
	public Teacher findTeacherByTid(int tid) {
		return td.getTeacherByTid(tid);
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
	public int changeTeacherToBossByTid(int tid, String hiredate, int cid) {
		return td.updTeacherToBossByTid(tid, hiredate, cid);
	}

	/**
	 * 根据教师名称查询
	 * 教师编号、教师姓名、教师性别、任职日期、任职科目
	 * 涉及表 : teacher(教师表)、assign(教师任职任课表)、subject(课程表)
	 * @param name 教师姓名
	 * @return
	 */
	@Override
	public List<TeacherSub> findTeacherSubListByTeacherName(String name) {
		return td.getTeacherSubListByTeacherName(name);
	}

	/**
	 * 根据教师任职科目查询
	 * 教师编号、教师姓名、教师性别、任职日期、任职科目
	 * 涉及表 : teacher(教师表)、assign(教师任职任课表)、subject(课程表)
	 * @param name 教师姓名
	 * @return
	 */
	@Override
	public List<TeacherSub> findTeacherSubListBySubname(String subname) {
		return td.getTeacherSubListBySubname(subname);
	}

	/**
	 * 根据教师ID将教师离职
	 * @param tid
	 * @return
	 */
	@Override
	public int leaveOfficeTeacherService(int tid) {
		return td.leaveOfficeTeacherDao(tid);
	}

	/**
	 * 查询所有班主任信息
	 * 教师编号、教师姓名、教师性别、任课课程、年级、专业名称
	 * 通过班级名称、年级、专业名称
	 * @return
	 */
	@Override
	public List<TeacherBoss> findTeacherBossListByGCMN(int grade, String cname,
			String mname, int num) {
		return td.teacherBossListByGCMN(grade, cname, mname, num);
	}
	
	
}
