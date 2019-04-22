package com.xyq.service.impl;

import com.xyq.entity.Car;
import com.xyq.entity.Customer;
import com.xyq.entity.Rental;
import com.xyq.entity.RentalPage;
import com.xyq.mapper.RentalMapper;
import com.xyq.service.RentalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class RentalServiceImpl implements RentalService {
	
	@Resource
	private RentalMapper rentalMapper;

	/**
	 * 按条件分页查询出租单信息
	 */
	@Override
	public RentalPage selRentalBySomeCondition(Rental rental, Customer customer, Integer pageNum, Integer pageSize) {

		RentalPage page = new RentalPage();

		int pageStart=pageNum*pageSize-pageSize;
		int count = rentalMapper.selRentalCounts(rental, customer);
		int pages=(int) Math.ceil(count*1.0/pageSize);
		List<Rental> rentalList = rentalMapper.selRentalBySomeCondition(rental, customer, pageStart, pageSize);

		page.setPageStart(pageStart);
		page.setPageSize(pageSize);
		page.setCount(count);
		page.setRentalList(rentalList);
		page.setPages(pages);
		page.setPageNum(pageNum);
		
		return page;
	}

	/**
	 * 根据出租单号查找出租信息
	 */
	@Override
	public Rental selRentalByRentid(int rentid) {
		return rentalMapper.selRetalByRentid(rentid);
	}

	/**
	 * 根据身份证号查找客户信息
	 */
	@Override
	public Customer selCustomerByIdcard(String idcard) {
		return rentalMapper.selCustomerByIdcard(idcard);
	}

	/**
	 * 根据车编号查找车辆信息
	 * @param carid
	 * @return
	 */
	@Override
	public Car selCarByCarid(int carid) {
		return rentalMapper.selCarByCarid(carid);
	}

	/**
	 * 修改车辆状态信息以及出租单信息
	 * @param rental
	 * @return
	 */
	@Override
	public int updateAllStatus(int carid, Rental rental) {
		int num = rentalMapper.updateCarStatus(carid, rental);
		num+= rentalMapper.updateRental(rental);
		return num;
	}

	/**
	 * 添加操作日志
	 */
	@Override
	public int insertSlfInfo(int uid, String oper,String success) {
		return rentalMapper.insertSlfInfo(uid, oper, success);
	}
	
	

}
