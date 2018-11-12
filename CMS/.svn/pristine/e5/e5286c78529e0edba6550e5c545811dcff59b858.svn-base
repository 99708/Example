package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.Teacher;
import com.bjsxt.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	@Override
	public int addUser(Student stu) {
		
		return userDao.addUser(stu);
	}
	@Override
	public int addUser(Teacher tea) {
		// TODO Auto-generated method stub
		return userDao.addUser(tea);
	}
	@Override
	public Student findStudentInfo(int i, String str) {
		if(i==1){//登陆用户名
			Student stu = userDao.getStudentInfo1(str);
			return stu;
		}else if (i==2){//名称
			Student stu = userDao.getStudentInfo2(str);
			return stu;
		}
		return null;
	}
	@Override
	public Teacher findTeacherInfo(int i, String str) {
		if(i==1){//登陆用户名
			Teacher tea = userDao.getTeacherInfo1(str);
			return tea;
		}else if (i==2){//名称
			Teacher tea = userDao.getTeacherInfo2(str);
			return tea;
		}
		return null;
	}
	@Override
	public List<Student> findStudents(int name, String searchText) {
		return userDao.getStudents(name,searchText);
	}
	@Override
	public List<Teacher> findTeachers(int name, String searchText) {
		return userDao.getTeachers(name,searchText);
	}
	@Override
	public int updateStudentPwd(int id, String pwd) {
		return userDao.updateStudentPwd(id,pwd);
	}
	@Override
	public int updateTeacherPwd(int id, String pwd) {
		return userDao.updateTeacherPwd(id,pwd);
	}
}
