package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.LoginDao;
import com.bjsxt.dao.impl.LoginDaoImpl;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.Teacher;
import com.bjsxt.service.LoginService;

public class LoginServiceImpl implements LoginService {
	LoginDao loginDao = new LoginDaoImpl();
	/**
	 * 学生
	 * */
	@Override
	public Student getStudentInfo(String uname, String pwd) {
		
		return loginDao.getStudentInfo(uname,pwd);
	}
	/**
	 * 老师和管理员
	 * */
	@Override
	public Teacher getTeacherInfo(String uname, String pwd,int rid) {
		return loginDao.getTeacherInfo(uname,pwd,rid);
	}
	
	/**
	 * rbac
	 */
	@Override
	public List<Menu> getMenuInfo(int rid) {
		List<Menu> lm=loginDao.getMenuDao(rid,0);
		//查询二级菜单信息
		for(Menu m:lm){
			List<Menu> lm2	=loginDao.getMenuDao(rid, m.getMid());
			m.setLm(lm2);
		}
		return lm;
	}


}
