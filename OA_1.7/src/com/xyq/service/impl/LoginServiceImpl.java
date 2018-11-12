package com.xyq.service.impl;

import com.xyq.dao.LoginDao;
import com.xyq.dao.impl.LoginDaoImpl;
import com.xyq.entity.Emp;
import com.xyq.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	LoginDao loginDao = new LoginDaoImpl();
	
	/**
	 * 验证登录信息
	 * @param empid
	 * @param password
	 * @return
	 */
	@Override
	public Emp login(String empid, String password) {
		return loginDao.login(empid, password);
	}

}
