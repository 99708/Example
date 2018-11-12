package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Classes;
import com.bjsxt.pojo.Major;
import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.StudentPage;

public interface StudentService {
	
	public List<Classes> findAllClasses();//查询所有班级信息

	public Major findMajorByMid(int mid);//根据mid查询major信息

	public Student findMyInfoBySid(int sid);//根据sid查询学生信息

	public int findMidByCid(int cid);//根据cid查mid

	public String findCnameByCid(int cid);//根据cid查cname

	public int addStudent(Student student);//添加学生信息

	public StudentPage findStudents(String sid, String cid, int num,
			int pageSize);//根据学生id班级id进行分页查询

	public Student findStudentBySid(int sid);//根据sid查询学生信息

	public int updateStudent(Student student);//修改学生信息

	public int findGcodeByCid(int cid);//根据cid查找年级

}
