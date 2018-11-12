package com.xyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xyq.service.PaymentService;
import com.xyq.service.impl.PaymentServiceImpl;
import com.xyq.vo.PayMentVo;


public class PaymentServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	public void findPaymentByType(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		//调用Service层方法
		PaymentService paymentService = new PaymentServiceImpl();
		List<PayMentVo> payMentVoList = paymentService.findPaymentByType();
		//转成json
		Gson gson = new Gson();
		String incomeVolistJson = gson.toJson(payMentVoList);
		//设置响应类型
		resp.setContentType("text/json");
		//响应给前端页面
		resp.getWriter().println(incomeVolistJson);
	}

}
