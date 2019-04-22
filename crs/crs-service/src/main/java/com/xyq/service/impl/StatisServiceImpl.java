package com.xyq.service.impl;

import com.xyq.entity.Rental;
import com.xyq.entity.RentalPage;
import com.xyq.mapper.StatisMapper;
import com.xyq.service.StatisService;
import com.xyq.vo.CarTypeVO;
import com.xyq.vo.IncomeVO;
import com.xyq.vo.ReturnTimeVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class StatisServiceImpl implements StatisService {
	
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
