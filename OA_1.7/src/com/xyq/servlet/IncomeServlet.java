package com.xyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xyq.service.IncomeService;
import com.xyq.service.impl.IncomeServiceImpl;
import com.xyq.vo.IncomeVo;


public class IncomeServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;

	public void findIncomeByType(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//调用Service层的方法
		IncomeService incomeService = new IncomeServiceImpl();
		List<IncomeVo> incomeVolist = incomeService.findIncomeByType();
		//转换为json
		Gson gson = new Gson();
		String incomeVolistJson = gson.toJson(incomeVolist);
		//设置响应类型
		resp.setContentType("text/json");
		//响应给前端页面
		resp.getWriter().println(incomeVolistJson);
	}
}
