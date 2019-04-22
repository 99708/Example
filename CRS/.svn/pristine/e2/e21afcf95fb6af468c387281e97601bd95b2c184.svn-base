package com.bjsxt.service;

import com.bjsxt.pojo.Car;
import com.bjsxt.pojo.Customer;
import com.bjsxt.pojo.Rental;
import com.bjsxt.pojo.RentalPage;

/**
 * 出租单管理业务层接口
 * @author Qiao
 *
 */
public interface RentalService {

	/**
	 * 根据多重条件分页查找出租单
	 * @param rental
	 * @return
	 */
	public RentalPage selRentalBySomeCondition(String rentid,String begindata,String dateable,String returndate,String idcard,String carid,String status,String uid,int pageNum,int pageSize);
	
	/**
	 * 根据出租单号查找出租信息
	 * @param rentid
	 * @return
	 */
	public Rental selRentalByRentid(int rentid);
	
	/**
	 * 根据身份证号查找客户信息
	 * @param rentid
	 * @return
	 */
	public Customer selCustomerByIdcard(String idcard);
	
	/**
	 * 根据车编号查找车辆信息
	 * @param idcard
	 * @return
	 */
	public Car selCarByCarid(int carid);
	
	/**
	 * 修改车辆状态信息以及出租单信息
	 * @param rental
	 * @return
	 */
	public int updateAllStatus(int carid,Rental rental);
	
	/**
	 * 添加操作日志
	 * @param uid
	 * @param oper
	 * @return
	 */
	public int insertSlfInfo(int uid,String oper,String success);
}
