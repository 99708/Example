package com.xyq.mapper;

import com.xyq.entity.Car;
import com.xyq.entity.Customer;
import com.xyq.entity.Rental;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 出租单管理mapper层
 * @author Qiao
 *
 */
public interface RentalMapper {

	/**
	 * 根据多重条件分页查找出租单
	 * @param rental
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Rental> selRentalBySomeCondition(@Param("rental") Rental rental, @Param("customer") Customer customer, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

	/**
	 * 查询记录总条数
	 * @param rental
	 * @return
	 */
	public int selRentalCounts(@Param("rental") Rental rental, @Param("customer") Customer customer);
	
	/**
	 * 根据出租单号查找出租信息
	 * @param rentid
	 * @return
	 */
	@Select("select * from rental where rentid = #{0}")
	public Rental selRetalByRentid(int rentid);
	
	/**
	 * 根据身份证号查找客户信息
	 * @param idcard
	 * @return
	 */
	@Select("select * from customer where idcard = #{0} ")
	public Customer selCustomerByIdcard(String idcard);

	/**
	 * 根据车编号查找车辆信息
	 * @param carid
	 * @return
	 */
	@Select("select * from car where carid = #{0}")
 	public Car selCarByCarid(int carid);
	
	/**
	 * 修改出租单信息
	 * @param rental
	 * @return
	 */
	@Update("update rental set priced=#{priced} , begindate=#{begindate} , dateable=#{dateable} , returndate=#{returndate} , status=#{status} where rentid=#{rentid}")
	public int updateRental(Rental rental);
	
	/**
	 * 修改车辆状态信息
	 * @param rental
	 * @return
	 */
	@Update("update car set status=#{param2.status} where carid=#{param1}")
	public int updateCarStatus(int carid, Rental rental);
	
	/**
	 * 添加操作日志
	 * @param uid
	 * @param oper
	 * @return
	 */
	@Insert("insert into slf values(DEFAULT, #{0},#{1},now(),0,#{2})")
	public int insertSlfInfo(int uid, String oper, String success);
}
