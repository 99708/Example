package com.xyq.service;

import com.xyq.entity.*;

/**
 * 检查单管理业务层接口
 * @author Qiao
 *
 */
public interface CheckedService {
	
	/**
	 * 根据多重条件分页查找检查单
	 * @param checkid
	 * @param checkdate
	 * @param uname
	 * @param rentid
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public CheckedPage selCheckedBySomeCondition(String checkid, String checkdate, String uname, String rentid, int pageNum, int pageSize);
 
	/**
	 * 根据检查单号查找检查信息
	 * @param checkid
	 * @return
	 */
	public Checked selCheckedByCheckid(int checkid);

	/**
	 * 根据姓名查找管理员信息
	 * @param uname
	 * @return
	 */
	public User selUserByUname(String uname);
	
	/**
	 * 根据出租单号查找出租信息
	 * @param rentid
	 * @return
	 */
	public Rental selRentalByRentid(int rentid);

	/**
	 * 根据出租单号中的车辆号查找车辆信息
	 * @param rental
	 * @return
	 */
	public Car selCarByRentalCarid(Rental rental);
	
	/**
	 * 根据出租单号中的身份证号查找顾客信息
	 * @param rental
	 * @return
	 */
	public Customer selCustomerByRentalIdcard(Rental rental);
	
	/**
	 * 修改检查单信息
	 * @param checkid
	 * @param problem
	 * @param pay
	 * @return
	 */
	public int updateChecked(int checkid, String problem, double pay);

	/**
	 * 删除检查单信息
	 * @param checkid
	 * @return
	 */
	public int deleteChecked(int checkid);
	
	/**
	 * 添加操作日志
	 * @param uid
	 * @param oper
	 * @return
	 */
	public int insertSlfInfo(int uid, String oper, String success);
}
