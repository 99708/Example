package com.xyq.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//1、设置编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		//2、获取请求数据
		String method = req.getParameter("method");
		//2、使用反射进行封装
		//2.1、获得类对象
		Class<? extends BaseServlet> clazz = this.getClass();
		//2.2、获得类中指定的声明方法
		try {
			Method method2 = clazz.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			Object object = method2.invoke(this, req, resp);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
