package com.xyq.service;


import com.xyq.entity.Car;
import com.xyq.entity.CarPage;

/**
 * 汽车管理Service
 * @author HaoziDada
 */
public interface CarService {

	/**
	 * 添加汽车(汽车租赁上架)
	 * @param car
	 * @return
	 */
	int insertCarService(Car car);
	
	/**
	 * 查询所有的汽车，根据Car信息
	 * 分页查询
	 * @param car
	 * @return
	 */
	CarPage selectAllCarByCarInfoService(Car car, Integer num, Integer pageSize);
	
	/**
	 * 根据汽车ID查询汽车信息
	 * @param carid
	 * @return
	 */
	Car selectOneCarByCaridService(Integer carid);
	
	/**
	 * 根据汽车ID修改汽车全部信息
	 * @param car
	 * @return
	 */
	int updateOneCarByCaridService(Car car);
	
	/**
	 * 根据汽车ID删除汽车信息
	 * @param carid
	 * @return
	 */
	int deleteOneCarByCaridService(Integer carid);
}
