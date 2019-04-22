package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.StatisMapper;
import com.bjsxt.pojo.Rental;
import com.bjsxt.pojo.RentalPage;
import com.bjsxt.service.StatisService;
import com.bjsxt.vo.CarTypeVO;
import com.bjsxt.vo.IncomeVO;
import com.bjsxt.vo.ReturnTimeVO;

@Service
public class StatisServiceImpl implements StatisService{
	
	@Resource
	private StatisMapper statisMapper;

	@Override
	public RentalPage selCarReturn(String begindate, String dateable, Integer uid, int pageNum, int pageSize) {
		int pageStart = (pageNum - 1) * pageSize;
		List<Rental> rentalList = statisMapper.selCarReturn(begindate, dateable, uid, pageStart, pageSize);
		int count = statisMapper.selCountCarReturn(begindate, dateable, uid);
		int pageCount = (int) Math.ceil(count*1.0/pageSize);
		RentalPage rentalPage = new RentalPage(pageNum, pageSize, pageStart, pageCount, count, rentalList);
		return rentalPage;
	}

	@Override
	public List<CarTypeVO> selCarTypeCount() {
		return statisMapper.selCarTypeCount();
	}

	@Override
	public List<ReturnTimeVO> selReturnTime() {
		return statisMapper.selReturnTime();
	}

	@Override
	public List<IncomeVO> selIncomeVO() {
		return statisMapper.selIncomeVO();
	}
}