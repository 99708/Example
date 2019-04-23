package com.xyq.service;

import com.xyq.entity.*;

import java.util.List;



/**
 * 汽车租还操作
 * @author HaoziDada
 */
public interface CarOperService {
	
	/**
	 * 根据身份证校验客户
	 * @param idcard
	 * @return
	 */
	Customer selectCustomerByIdcardServie(String idcard);
	
	/**
	 * 根据状态查询汽车信息(可供租用)
	 * @param status
	 * @return
	 */
	List<Car> selectCarByStatusService(String status);
	
	/**
	 * 根据ID查询汽车信息(汽车出租)
	 * @param carid
	 * @return
	 */
	Car selectCarByIdService(Integer carid);
	
	/**
	 * 插入一条汽车出租单
	 * @param rt
	 * @return
	 */
	int insertCarRentService(Rental rt);

	/**
	 * 插入一条汽车出租单
	 * @return
	 */
	int updateCarStatusByCarid(String status, Integer carid);
	
	/**
	 * 根据rentid查询出租单信息
	 * @param rentid
	 * @return
	 */
	Rental selectOneRentalByRentidService(Integer rentid);
	
	/**
	 * 根据carid查询汽车信息
	 * @param carid
	 * @return
	 */
	Car selectOneCarByCaridService(Integer carid);
	
	/**
	 * 根据idcard查询客户信息
	 * @param idcard
	 * @return
	 */
	Customer selectOneCustByIdcardService(String idcard);
	
	/**
	 * 根据rentid获取idcard
	 * @param rentid
	 * @return
	 */
	String selectIdcardByRentidService(Integer rentid);
	
	/**
	 * 根据rentid获取carid
	 * @param rentid
	 * @return
	 */
	Integer selectCaridByRentidService(Integer rentid);
	
	/**
	 * 根据uid查询uname
	 * @param uid
	 * @return
	 */
	String selectUnameByUidService(Integer uid);
	
	/**
	 * 添加一条检查单数据
	 * @param ck
	 * @return
	 */
	int insertOneCheckedService(Checked ck);
	
	/**
	 * 通过rentid和carid修改对应表的状态
	 * @param status
	 * @param rentid
	 * @param carid
	 * @return
	 */
	int updateStatusByCaridAndRentId(String status, Integer rentid, Integer carid);
	
	/**
	 * 添加日志信息
	 * @return
	 */
	int insertIntoSlfService(Integer uid, String oper, String opertime, Integer status, String success);
	
	/**
	 * 根据uname获取uid(User表)
	 * @param uname
	 * @return
	 */
	Integer selectUidByUnameService(String uname);

	/**
	 * 三条件分页模糊查询SLF信息
	 * @param slfLog
	 * @param num
	 * @param pageSize
	 * @return
	 */
	SlfPage selectAllSLFByOUOService(SlfLog slfLog, Integer num, Integer pageSize);
	
	
}
