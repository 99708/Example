package com.xyq.service.impl;

import java.util.List;

import com.xyq.dao.PaymentDao;
import com.xyq.dao.impl.PaymentDaoImpl;
import com.xyq.service.PaymentService;
import com.xyq.vo.PayMentVo;

public class PaymentServiceImpl implements PaymentService{

	PaymentDao paymentDao = new PaymentDaoImpl();
	
	@Override
	public List<PayMentVo> findPaymentByType() {
		return paymentDao.getPaymentByType();
	}

}
