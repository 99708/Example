package com.xyq.dao;

import java.util.List;

import com.xyq.vo.PayMentVo;

public interface PaymentDao {
	public List<PayMentVo> getPaymentByType();
}
