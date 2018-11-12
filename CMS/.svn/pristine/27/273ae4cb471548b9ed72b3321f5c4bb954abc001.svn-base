package com.bjsxt.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//编码设置
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 访问servlet ,调用响应的 servlet的方法
		Class<? extends BaseServlet> clazz = this.getClass();
		
		String method = request.getParameter("method");
		/**
		 * 参数  ‘
		 * 		method  参数  类型  （class类型）
		 */
		try {
			Method m = clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			//调用 方法
			m.invoke(this, request, response);
		} catch ( Exception e) {
			e.printStackTrace();
		} 
	}
}