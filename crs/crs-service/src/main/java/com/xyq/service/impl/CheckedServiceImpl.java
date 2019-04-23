package com.xyq.service.impl;

import com.xyq.entity.*;
import com.xyq.mapper.CheckedMapper;
import com.xyq.service.CheckedService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CheckedServiceImpl implements CheckedService {

	@Resource
	private CheckedMapper checkedMapper;

	/**
	 * 根据多重条件分页查找检查单
	 */
	@Override
	public CheckedPage selCheckedBySomeCondition(String checkid, String checkdate, String uname, String rentid,
												 int pageNum, int pageSize) {
		int pageStart=pageNum*pageSize-pageSize;
		CheckedPage page = new CheckedPage();
		page.setPageStart(pageStart);
		page.setPageSize(pageSize);
		List<Checked> checkedList = checkedMapper.selCheckedBySomeCondition(checkid, checkdate, uname, rentid, pageStart, pageSize);
		int count = checkedMapper.selCheckedCounts(checkid, checkdate, uname, rentid);
		int pages=(int) Math.ceil(count*1.0/pageSize);
		page.setCount(count);
		page.setCheckedList(checkedList);
		page.setPages(pages);
		page.setPageNum(pageNum);
		return page;
	}

	/**
	 * 根据检查单号查找检查信息
	 */
	@Override
	public Checked selCheckedByCheckid(int checkid) {
		return checkedMapper.selCheckedByCheckid(checkid);
	}

	/**
	 * 根据姓名查找管理员信息
	 */
	@Override
	public User selUserByUname(String uname) {
		return checkedMapper.selUserByUname(uname);
	}

	/**
	 * 根据出租单号查找出租信息
	 */
	@Override
	public Rental selRentalByRentid(int rentid) {
		return checkedMapper.selRentalByRentid(rentid);
	}

	/**
	 * 根据出租单号中的车辆号查找车辆信息
	 */
	@Override
	public Car selCarByRentalCarid(Rental rental) {
		return checkedMapper.selCarByRentalCarid(rental);
	}

	/**
	 * 根据多重条件分页查找检查单
	 */
	@Override
	public Customer selCustomerByRentalIdcard(Rental rental) {
		return checkedMapper.selCustomerByRentalIdcard(rental);
	}

	/**
	 * 修改检查单信息
	 */
	@Override
	public int updateChecked(int checkid, String problem, double pay) {
		return checkedMapper.updateChecked(checkid, problem, pay);
	}

	/**
	 * 删除检查单信息
	 */
	@Override
	public int deleteChecked(int checkid) {
		return checkedMapper.deleteChecked(checkid);
	}

	/**
	 * 添加操作日志
	 */
	@Override
	public int insertSlfInfo(int uid, String oper, String success) {
		return checkedMapper.insertSlfInfo(uid, oper, success);
	}
}
