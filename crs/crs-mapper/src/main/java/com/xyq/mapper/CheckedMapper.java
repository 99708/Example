package com.xyq.mapper;

import com.xyq.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
 * 检查单mapper接口层
 * @author Qiao
 *
 */

public interface CheckedMapper {

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
	public List<Checked> selCheckedBySomeCondition(String checkid, String checkdate, String uname, String rentid, int pageNum, int pageSize);
	
	/**
	 * 查询记录总条数
	 * @param checkid
	 * @param checkdate
	 * @param uname
	 * @param rentid
	 * @return
	 */
	public int selCheckedCounts(String checkid, String checkdate, String uname, String rentid);
	
	/**
	 * 根据检查单号查找检查信息
	 * @param checkid
	 * @return
	 */
	@Select("select * from checked where checkid = #{0}")
	public Checked selCheckedByCheckid(int checkid);
	
	/**
	 * 根据姓名查找管理员信息
	 * @param uname
	 * @return
	 */
	@Select("select * from user where uname = #{0}")
	public User selUserByUname(String uname);
	
	/**
	 * 根据出租单号查找出租信息
	 * @param rentid
	 * @return
	 */
	@Select("select * from rental where rentid = #{0}")
	public Rental selRentalByRentid(int rentid);
	
	/**
	 * 根据出租单号中的车辆号查找车辆信息
	 * @param rental
	 * @return
	 */
	@Select("select * from car where carid = #{carid}")
	public Car selCarByRentalCarid(Rental rental);
	
	/**
	 * 根据出租单号中的身份证号查找顾客信息
	 * @param rental
	 * @return
	 */
	@Select("select * from customer where idcard = #{idcard}")
	public Customer selCustomerByRentalIdcard(Rental rental);
	
	/**
	 * 修改检查单信息
	 * @param checkid
	 * @param problem
	 * @param pay
	 * @return
	 */
	@Update("update checked set problem=#{1},pay=#{2} where checkid=#{0}")
	public int updateChecked(int checkid, String problem, double pay);
	
	/**
	 * 删除检查单信息
	 * @param checkid
	 * @return
	 */
	@Delete("delete from checked where checkid=#{0}")
	public int deleteChecked(int checkid);
	
	/**
	 * 添加操作日志
	 * @param uid
	 * @param oper
	 * @return
	 */
	@Insert("insert into slf values(DEFAULT, #{0},#{1},now(),0,#{2})")
	public int insertSlfInfo(int uid, String oper, String success);
}
