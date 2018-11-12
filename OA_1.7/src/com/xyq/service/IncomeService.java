package com.xyq.service;

import java.util.List;

import com.xyq.vo.IncomeVo;

public interface IncomeService {
	/**
	 * 收入统计
	 * @return
	 */
	public List<IncomeVo> findIncomeByType();
}
