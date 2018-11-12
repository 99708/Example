package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Classes;
import com.bjsxt.pojo.MajClasses;
import com.bjsxt.pojo.Major;
import com.bjsxt.pojo.Subject;
import com.bjsxt.pojo.Teacher;
import com.bjsxt.pojo.TeacherBoss;
import com.bjsxt.pojo.TeacherPage;
import com.bjsxt.pojo.TeacherSub;

public interface TeacherService {

	//乔
	
	List<Major> findMajor();//查找所有的专业信息

	int addTeacher(Teacher teacher);//添加老师信息

	TeacherPage findTeachers(int search, String searchText, int num,
			int pageSize);//按条件分页查询教师信息

	Teacher findTeacherByTid1(int tid);//根据tid查找老师信息
	
	String findMnameByMid(int mid);//根据mid查找Mname

	int updateTeacher(Teacher teacher);//修改老师信息

	Teacher findMyInfoByTid(Integer tid);//查找当前登录老师的信息

	List<Object> thinkFind(int search, String searchText);//通过ajax实现联想查询
	
	/**
	 * 获取TeacherList
	 * 功能 : 遍历科目(任课科目下拉框)
	 */
	List<Subject> findTeacherSub();
	
	/**
	 * 三条件查询教师(任课科目，教师编号，任职日期)
	 * 查询字段(教师姓名，性别，年龄，学历，授课专业，结婚状态)
	 * 分页查询
	 * @return
	 */
	TeacherPage findTeacherBySTH(String sname , int tid , String hiredate , int num , int pageSize);
	
	/**
	 * 获得所有班级信息
	 * 功能 : 遍历班级(班级下拉框)
	 * @return
	 */
	List<Classes> findTeacherClasses();
	
	/**
	 * 获得所有班级信息、专业信息、年级信息
	 * 功能 	: 遍历班级(通过班级下拉框选择查询)
	 * 		 	: 通过班级cid查询到对应专业
	 * 			: 通过班级cid查询到对应年级
	 * @return
	 */
	MajClasses findMajClassByCid(int cid);
	
	/**
	 * 获取教师信息
	 * 通过tid(教师ID)
	 * @param tid
	 * @return
	 */
	Teacher findTeacherByTid(int tid);
	
	/**
	 * 将老师变成班主任
	 * 修改assign表中cid字段，更换老师任课班级
	 * 修改teacher中hiredate(任职时间)、desc(职位)
	 * 老师班级专业信息会随之改变(外键关系)
	 * 通过tid找到老师
	 * @param tid
	 * @return
	 */
	int changeTeacherToBossByTid(int tid , String hiredate , int cid);
	
	/**
	 * 根据教师名称查询
	 * 教师编号、教师姓名、教师性别、任职日期、任职科目
	 * 涉及表 : teacher(教师表)、assign(教师任职任课表)、subject(课程表)
	 * @param name 教师姓名
	 * @return
	 */
	List<TeacherSub> findTeacherSubListByTeacherName(String name);

	/**
	 * 根据教师任职科目查询
	 * 教师编号、教师姓名、教师性别、任职日期、任职科目
	 * 涉及表 : teacher(教师表)、assign(教师任职任课表)、subject(课程表)
	 * @param name 教师姓名
	 * @return
	 */
	List<TeacherSub> findTeacherSubListBySubname(String subname);
	
	/**
	 * 根据教师ID将教师离职
	 * @param tid
	 * @return
	 */
	int leaveOfficeTeacherService(int tid);
	
	/**
	 * 查询所有班主任信息
	 * 教师编号、教师姓名、教师性别、任课课程、年级、专业名称
	 * 通过班级名称、年级、专业名称
	 * @return
	 */
	List<TeacherBoss> findTeacherBossListByGCMN( int grade , String cname , String mname , int num);
	
}
