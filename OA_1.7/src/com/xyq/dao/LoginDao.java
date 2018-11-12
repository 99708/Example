package com.xyq.dao;

import com.xyq.entity.Emp;

public interface LoginDao {
	/**
	 * 验证登录信息
	 * @param empid
	 * @param password
	 * @return
	 */
	public Emp login(String empid, String password);
}
