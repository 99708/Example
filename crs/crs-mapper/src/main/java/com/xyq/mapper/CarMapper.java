package com.xyq.mapper;

import com.xyq.entity.Car;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 汽车管理mapper
 * @author HaoziDada
 */
public interface CarMapper {
	
	/**
	 * 添加汽车
	 * @param car
	 * @return
	 */
	int insertCarMapper(Car car);
	
	/**
	 * 根据汽车信息查询所有汽车
	 * @return
	 */
	List<Car> selectAllCarMapper(@Param("c") Car car, @Param("num") Integer num, @Param("pageSize") Integer pageSize);
	
	/**
	 * 统计所有汽车数据量
	 * @param car
	 * @return
	 */
	int selectCountCarMapper(Car car);
	
	/**
	 * 根据汽车ID查询汽车信息
	 * @param carid
	 * @return
	 */
	Car selectOneCarByCaridMapper(@Param("carid") Integer carid);
	
	/**
	 * 根据汽车ID修改汽车全部信息
	 * @param car
	 * @return
	 */
	int updateOneCarByCaridMapper(Car car);
	
	/**
	 * 根据carid删除汽车信息
	 * @param carid
	 * @return
	 */
	@Delete("delete from car where carid = #{param0}")
	int deleteOneCarByCaridMapper(Integer carid);
}
