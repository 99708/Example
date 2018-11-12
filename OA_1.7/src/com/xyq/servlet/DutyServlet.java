package com.xyq.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyq.service.DutyService;
import com.xyq.service.impl.DutyServiceImpl;


public class DutyServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 查询员工的签到状态
	 * @param req
	 * @param resp
	 */
	public void findSign(HttpServletRequest req, HttpServletResponse resp){
		//调用Service层的方法
		DutyService dutyService = new DutyServiceImpl();
		
	}
}
