package com.xyq.service;

import java.util.List;

import com.xyq.vo.PayMentVo;

public interface PaymentService {
	/**
	 * 支持统计
	 * @return
	 */
	public List<PayMentVo> findPaymentByType();
}
