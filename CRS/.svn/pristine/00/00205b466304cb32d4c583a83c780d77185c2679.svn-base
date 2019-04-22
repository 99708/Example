package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.RentalPage;
import com.bjsxt.vo.CarTypeVO;
import com.bjsxt.vo.IncomeVO;
import com.bjsxt.vo.ReturnTimeVO;

/**
 * 统计处理
 * @author 997
 *
 */
public interface StatisService {

	/**
	 * 查询当月的应还车辆
	 * @return 
	 */
	RentalPage selCarReturn(String begindate, String dateable, Integer uid, int pageNum, int pageSize);
	
	/**
	 * 统计最受欢迎的车型
	 * @return
	 */
	List<CarTypeVO> selCarTypeCount();
	
	/**
	 * 统计租期
	 * @return
	 */
	List<ReturnTimeVO> selReturnTime();
	
	/**
	 * 统计收入
	 * @return
	 */
	List<IncomeVO> selIncomeVO();
}
