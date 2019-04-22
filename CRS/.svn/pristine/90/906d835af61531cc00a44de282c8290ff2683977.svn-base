package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.CarOperMapper;
import com.bjsxt.pojo.Car;
import com.bjsxt.pojo.CarPage;
import com.bjsxt.pojo.Checked;
import com.bjsxt.pojo.Customer;
import com.bjsxt.pojo.Rental;
import com.bjsxt.pojo.SlfLog;
import com.bjsxt.pojo.SlfPage;
import com.bjsxt.service.CarOperService;

@Service
public class CarOperServiceImpl implements CarOperService{

	//声明carOperMapper属性
	@Resource
	private CarOperMapper carOperMapper;
	
	/**
	 * 根据身份证校验客户
	 * @param idcard
	 * @return
	 */
	@Override
	public Customer selectCustomerByIdcardServie(String idcard) {
		return carOperMapper.selectCustomerByIdcardMapper(idcard);
	}

	//根据状态查询汽车信息(可供租用)
	@Override
	public List<Car> selectCarByStatusService(String status) {
		return carOperMapper.selectCarByStatus(status);
	}

	/**
	 * 根据ID查询汽车信息(汽车出租)
	 * @param carid
	 * @return
	 */
	@Override
	public Car selectCarByIdService(Integer carid) {
		return carOperMapper.selectCarByIdMapper(carid);
	}

	/**
	 * 插入一条汽车出租单
	 * @param rt
	 * @return
	 */
	@Override
	public int insertCarRentService(Rental rt) {
		return carOperMapper.insertCarRentMapper(rt);
	}

	/**
	 * 插入一条汽车出租单
	 * @return
	 */
	@Override
	public int updateCarStatusByCarid(String status, Integer carid) {
		return carOperMapper.updateCarStatusByCaridMapper(status, carid);
	}

	/**
	 * 根据rentid查询出租单信息
	 * @param rentid
	 * @return
	 */
	@Override
	public Rental selectOneRentalByRentidService(Integer rentid) {
		return carOperMapper.selectOneRentalByRentidMapper(rentid);
	}

	/**
	 * 根据carid查询汽车信息
	 * @param carid
	 * @return
	 */
	@Override
	public Car selectOneCarByCaridService(Integer carid) {
		return carOperMapper.selectOneCarByCaridMapper(carid);
	}

	/**
	 * 根据idcard查询客户信息
	 * @param idcard
	 * @return
	 */
	@Override
	public Customer selectOneCustByIdcardService(String idcard) {
		return carOperMapper.selectOneCustByIdcardMapper(idcard);
	}

	/**
	 * 根据rentid获取idcard
	 * @param rentid
	 * @return
	 */
	@Override
	public String selectIdcardByRentidService(Integer rentid) {
		return carOperMapper.selectIdcardByRentidMapper(rentid);
	}

	/**
	 * 根据rentid获取carid
	 * @param rentid
	 * @return
	 */
	@Override
	public Integer selectCaridByRentidService(Integer rentid) {
		return carOperMapper.selectCaridByRentidMapper(rentid);
	}

	/**
	 * 根据uid查询uname
	 * @param uid
	 * @return
	 */
	@Override
	public String selectUnameByUidService(Integer uid) {
		return carOperMapper.selectUnameByUidMapper(uid);
	}

	/**
	 * 添加一条检查单数据
	 * @param ck
	 * @return
	 */
	@Override
	public int insertOneCheckedService(Checked ck) {
		return carOperMapper.insertOneCheckedMapper(ck);
	}

	@Override
	public int updateStatusByCaridAndRentId(String status, Integer rentid, Integer carid) {
		int num1 = carOperMapper.updateStatusByCaridMapper(status, carid);
		int num2 = carOperMapper.updateStatusByRentidMapper(status, rentid);
		if(num1 > 0 && num2 >0){
			return num1 + num2;
		}
		return -1;
	}

	/**
	 * 添加日志信息
	 * @return
	 */
	@Override
	public int insertIntoSlfService(Integer uid, String oper, String opertime, Integer status, String success) {
		return carOperMapper.insertSlfMapper(uid, oper, opertime, status, success);
	}

	/**
	 * 根据uname获取uid(User表)
	 * @param uname
	 * @return
	 */
	@Override
	public Integer selectUidByUnameService(String uname) {
		return carOperMapper.selectUidByUnameService(uname);
	}

	/**
	 * 三条件分页模糊查询SLF信息
	 * @param oper
	 * @param uname
	 * @param opertime
	 * @param num
	 * @param pageSize
	 * @return
	 */
	@Override
	public SlfPage selectAllSLFByOUOService(String oper, Integer uid, String opertime, Integer num,
			Integer pageSize) {
		
		//将查询页码转换为起始查询行号
		int pageStart = num*pageSize-pageSize;
		//获取总的数据量
		int count = carOperMapper.selectCountSLFByThree(oper, uid, opertime);
		//获取总的分页数量
		int pages = (int) Math.ceil(count*1.0/pageSize);
		//获取分页数据
		List<SlfLog> cs = carOperMapper.selectAllSLFByOUO(oper, uid, opertime, pageStart, pageSize);
		
		//创建Page对象封装分页查询相关的所有数据，便于响应
		SlfPage sp = new SlfPage();
		sp.setCount(count);
		sp.setNum(num);
		sp.setPages(pages);
		sp.setPageSize(pageSize);
		sp.setSlf(cs);
		
		return sp;
	}
	
}
