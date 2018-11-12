package com.xyq.service;

import com.xyq.entity.Emp;

public interface LoginService {
	/**
	 * 验证登录信息
	 * @param empid
	 * @param password
	 * @return
	 */
	public Emp login(String empid, String password);
}
