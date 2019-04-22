package com.xyq.service.impl;

import com.xyq.entity.CusPage;
import com.xyq.entity.Customer;
import com.xyq.mapper.CustomersMapper;
import com.xyq.service.CustomersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomersServiceImpl implements CustomersService {
	@Resource
	private CustomersMapper customersMapper;
	/**
	 * 添加用户
	 */
	@Override
	public int insCus(Customer cus) {
		
		return customersMapper.insCus(cus);
	}
	/**
	 * 分页查询用户
	 */
	@Override
	public CusPage selCus(Customer cus, int pageNum, int pageSize) {
		CusPage cusPage = new CusPage();
		int count = customersMapper.selCount(cus);
		int pageStart = (pageNum - 1) * pageSize;
		int pages = (int)Math.ceil(count*1.0/pageSize);
		List<Customer> lc = customersMapper.selCus(cus, pageStart, pageSize);
		cusPage.setCount(count);
		cusPage.setCustomerList(lc);
		cusPage.setPageNum(pageNum);
		cusPage.setPageSize(pageSize);
		cusPage.setPageStart(pageStart);
		cusPage.setPages(pages);
		return cusPage;
	}
	/**
	 * 根据idcard查询客户信息
	 */
	@Override
	public Customer selOneCus(String idcard) {
		
		return customersMapper.selOneCus(idcard);
	}
	/**
	 * 修改用户信息
	 */
	@Override
	public int upCus(Customer cus) {
		
		return customersMapper.upCus(cus);
	}
	/**
	 * 删除客户信息
	 */
	@Override
	public int delCus(String idcard) {
		return customersMapper.delCus(idcard);
	}
	/**
	 * 根据idcard和密码修改客户密码
	 */
	@Override
	public int upCusPwd(String idcard, String oldPwd, String newPwd) {
		
		return customersMapper.upCusPwd(idcard, oldPwd, newPwd);
	}
	/**
	 * 校验用户
	 */
	@Override
	public Customer selCusByIdcard(String idcard) {
		return customersMapper.selCusByIdcard(idcard);
	}
}
