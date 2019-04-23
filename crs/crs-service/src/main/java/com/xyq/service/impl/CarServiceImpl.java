package com.xyq.service.impl;

import com.xyq.entity.Car;
import com.xyq.entity.CarPage;
import com.xyq.mapper.CarMapper;
import com.xyq.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 汽车管理Service
 * @author HaoziDada
 */
@Service
public class CarServiceImpl implements CarService {

	//声明汽车管理Mapper属性
	@Resource
	private CarMapper carMapper;
	
	//添加汽车租赁
	@Override
	public int insertCarService(Car car) {
		return carMapper.insertCarMapper(car);
	}

	//根据Car信息查询所有汽车(分页查询)
	@Override
	public CarPage selectAllCarByCarInfoService(Car car , Integer num , Integer pageSize) {

		//将查询页码转换为起始查询行号
		int pageStart = num*pageSize-pageSize;
		//获取总的数据量
		int count = carMapper.selectCountCarMapper(car);
		//获取总的分页数量
		int pages = (int) Math.ceil(count*1.0/pageSize);
		//获取分页数据
		List<Car> cs = carMapper.selectAllCarMapper(car , pageStart , pageSize);
		
		//创建Page对象封装分页查询相关的所有数据，便于响应
		CarPage cp = new CarPage();
		cp.setCount(count);
		cp.setCs(cs);
		cp.setNum(num);
		cp.setPages(pages);
		cp.setPageSize(pageSize);
		return cp;
	}

	//根据汽车ID查询汽车信息
	@Override
	public Car selectOneCarByCaridService(Integer carid) {
		return carMapper.selectOneCarByCaridMapper(carid);
	}

	//根据汽车ID修改汽车全部信息
	@Override
	public int updateOneCarByCaridService(Car car) {
		return carMapper.updateOneCarByCaridMapper(car);
	}

	//根据汽车ID删除汽车信息
	@Override
	public int deleteOneCarByCaridService(Integer carid) {
		return carMapper.deleteOneCarByCaridMapper(carid);
	}
	
	
}
