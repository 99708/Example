package com.xyq.dao;

import java.util.List;

import com.xyq.vo.IncomeVo;

public interface IncomeDao {
	//收入统计
	public List<IncomeVo> getIncomeByType();
}
