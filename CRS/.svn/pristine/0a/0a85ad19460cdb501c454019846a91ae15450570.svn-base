package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bjsxt.pojo.Customer;

public interface CustomersMapper {
	//添加客户
	int insCus(Customer cus);
		
	//查询客户总条数
	int selCount(@Param("c")Customer cus);
	//分页查询客户信息
	List<Customer> selCus(@Param("c")Customer cus,@Param("pageStart")int pageStart);
	//根据idcard查询客户
	Customer selOneCus(String idcard);
	//修改客户信息
	int upCus(Customer cus);
	//删除客户信息
	int delCus(String idcard);
	//根据idcard和pwd修改客户密码
	int upCusPwd(String idcard,String oldPwd,String newPwd);
	//校验用户
	Customer selCusByIdcard(String idcard);
}
