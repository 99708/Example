package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.pojo.Classes;
import com.bjsxt.pojo.Major;
import com.bjsxt.pojo.Student;

public interface StudentDao {

	public List<Classes> getAllClasses();//查询所有的班级信息

	public Major getMajorByMid(int mid);//根据mid查询major信息

	public Student getMyInfoBySid(int sid);//根据sid查询学生信息

	public int getMidByCid(int cid);//根据cid查mid

	public String getCnameByCid(int cid);//根据cid查cname

	public int addStudent(Student student);//添加学生信息

	public int getCount(String sid, String cid);//获取元素总数

	public List<Student> getStudents(String sid, String cid, int pageStart,
			int pageSize);//按条件分页查询

	public int updateStudent(Student student);//修改学生信息

	public int getGcodeByCid(int cid);//根据cid查找年级

}
