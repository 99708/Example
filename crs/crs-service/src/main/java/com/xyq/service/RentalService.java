package com.xyq.service;


import com.xyq.entity.Car;
import com.xyq.entity.Customer;
import com.xyq.entity.Rental;
import com.xyq.entity.RentalPage;

/**
 * 出租单管理业务层接口
 * @author Qiao
 *
 */
public interface RentalService {

	/**
	 * 根据多重条件分页查找出租单
	 * @param rental
	 * @param pageNum
	 * @param PageSize
	 * @return
	 */
	public RentalPage selRentalBySomeCondition(Rental rental, Customer customer, Integer pageNum, Integer PageSize);

	/**
	 * 根据出租单号查找出租信息
	 * @param rentid
	 * @return
	 */
	public Rental selRentalByRentid(int rentid);

	/**
	 * 根据身份证号查找客户信息
	 * @param idcard
	 * @return
	 */
	public Customer selCustomerByIdcard(String idcard);

	/**
	 * 根据车编号查找车辆信息
	 * @param carid
	 * @return
	 */
	public Car selCarByCarid(int carid);
	
	/**
	 * 修改车辆状态信息以及出租单信息
	 * @param rental
	 * @return
	 */
	public int updateAllStatus(int carid, Rental rental);
	
	/**
	 * 添加操作日志
	 * @param uid
	 * @param oper
	 * @return
	 */
	public int insertSlfInfo(int uid, String oper, String success);
}
