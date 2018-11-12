package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.Teacher;

public interface UserDao {

	int addUser(Student stu);

	int addUser(Teacher tea);

	Student getStudentInfo1(String str);

	Student getStudentInfo2(String str);

	Teacher getTeacherInfo1(String str);

	Teacher getTeacherInfo2(String str);

	List<Student> getStudents(int name, String searchText);

	List<Teacher> getTeachers(int name, String searchText);

	int updateStudentPwd(int id, String pwd);

	int updateTeacherPwd(int id, String pwd);

}
