package com.xyq.service.impl;

import java.util.List;

import com.xyq.dao.IncomeDao;
import com.xyq.dao.impl.IncomeDaoImpl;
import com.xyq.service.IncomeService;
import com.xyq.vo.IncomeVo;

public class IncomeServiceImpl implements IncomeService{

	IncomeDao incomeDao = new IncomeDaoImpl();
	
	@Override
	public List<IncomeVo> findIncomeByType() {
		return incomeDao.getIncomeByType();
	}

}
