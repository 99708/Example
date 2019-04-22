package com.bjsxt.service;

import com.bjsxt.pojo.CusPage;
import com.bjsxt.pojo.Customer;

public interface CustomersService {
	/**
	 * 添加用户
	 * @param cus
	 * @return
	 */
	int insCus(Customer cus);
	/**
	 * 分页查询客户信息
	 * @param cus
	 * @param pageNum
	 * @return
	 */
	CusPage selCus(Customer cus,int pageNum);
	/**
	 * 根据idcard查询客户信息
	 * @param idcard
	 * @return
	 */
	Customer selOneCus(String idcard);
	/**
	 * 修改用户信息
	 * @param cus
	 * @return
	 */
	int upCus(Customer cus);
	/**
	 * 删除客户信息
	 * @param idcard
	 * @return
	 */
	int delCus(String idcard);
	/**
	 * 根据idcard和密码修改客户密码
	 */
	int upCusPwd(String idcard,String oldPwd,String newPwd);
	/**
	 * 校验用户
	 */
	Customer selCusByIdcard(String idcard);
}
