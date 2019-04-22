package com.xyq.mapper;

import com.xyq.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
 * 汽车租还操作
 * 
 * @author HaoziDada
 */
public interface CarOperMapper {

	/**
	 * 根据身份证查询客户
	 * 
	 * @param idcard
	 * @return
	 */
	@Select("select * from customer where idcard = #{param1}")
	Customer selectCustomerByIdcardMapper(String idcard);

	/**
	 * 根据状态查询汽车(可供租用)
	 * 
	 * @param status
	 * @return
	 */
	@Select("select * from car where `status` = #{param1}")
	List<Car> selectCarByStatus(String status);

	/**
	 * 根据ID查询汽车信息(汽车出租)
	 * 
	 * @return
	 */
	@Select("select * from car where carid = #{param1}")
	Car selectCarByIdMapper(Integer carid);

	/**
	 * 插入一条汽车出租单
	 * 
	 * @return
	 */
	int insertCarRentMapper(Rental rt);

	/**
	 * 通过Carid修改汽车状态
	 * 
	 * @param status
	 * @param carid
	 * @return
	 */
	@Update("update car set status = #{param1} where carid = #{param2}")
	int updateCarStatusByCaridMapper(String status, Integer carid);

	/**
	 * 根据rentid获取idcard
	 * 
	 * @param rentid
	 * @return
	 */
	@Select("select idcard from rental where rentid = #{param1}")
	String selectIdcardByRentidMapper(Integer rentid);

	/**
	 * 根据rentid获取carid
	 * 
	 * @param rentid
	 * @return
	 */
	@Select("select carid  from rental where rentid = #{param1}")
	Integer selectCaridByRentidMapper(Integer rentid);

	/**
	 * 根据rentid查询出租单信息
	 * 
	 * @return
	 */
	@Select("select * from rental where rentid = #{param1}")
	Rental selectOneRentalByRentidMapper(Integer rentid);

	/**
	 * 根据carid查询汽车信息
	 * 
	 * @param carid
	 * @return
	 */
	@Select("select * from car where carid = #{param1}")
	Car selectOneCarByCaridMapper(Integer carid);

	/**
	 * 根据idcard查询客户信息
	 * 
	 * @param idcard
	 * @return
	 */
	@Select("select * from customer where idcard = #{param1}")
	Customer selectOneCustByIdcardMapper(String idcard);

	/**
	 * 根据uid查询uname
	 * 
	 * @param uid
	 * @return
	 */
	@Select("select uname from user where uid = #{param1}")
	String selectUnameByUidMapper(Integer uid);

	/**
	 * 添加一条检查单数据
	 * @param ck
	 * @return
	 */
	@Insert("insert into checked values(#{checkid} , #{checkdate} , #{problem} , #{pay} , #{uid} , #{rentid})")
	int insertOneCheckedMapper(Checked ck);

	/**
	 * 根据rentid修改出租单的状态
	 * @param status
	 * @param rentid
	 * @return
	 */
	@Update("update rental set status = #{param1} where rentid = #{param2}")
	int updateStatusByRentidMapper(String status, Integer rentid);
	
	/**
	 * 根据carid修改汽车状态
	 * @param status
	 * @param carid
	 * @return
	 */
	@Update("update car set status = #{param1} where carid = #{param2}")
	int updateStatusByCaridMapper(String status, Integer carid);

	/**
	 * 添加日志信息
	 * @return
	 */
	@Insert("insert into slf values(default , #{param1} , #{param2} , #{param3} , #{param4} , #{param5})")
	int insertSlfMapper(Integer uid, String oper, String opertime, Integer status, String success);
	
	/**
	 * 根据uname获取uid(User表)
	 * @param uname
	 * @return
	 */
	@Select("select uid from user where uname = #{param1}")
	Integer selectUidByUnameService(String uname);

	/**
	 * 三条件获取SLF统计数量
	 * @param slfLog
	 * @return
	 */
	Integer selectCountSLFByThree(@Param("slf") SlfLog slfLog);

	/**
	 * 三条件分页模糊查询SLF信息
	 * @param slfLog
	 * @param num
	 * @param pageSize
	 * @return
	 */
	List<SlfLog> selectAllSLFByOUO(@Param("slf") SlfLog slfLog, @Param("num") Integer num, @Param("pageSize") Integer pageSize);
	
	
}
