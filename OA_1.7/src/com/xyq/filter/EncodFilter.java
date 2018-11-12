package com.xyq.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xyq.entity.Emp;

public class EncodFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//0、转换
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
		//1、编码设定
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
		//2、登录过滤
			//策略是看session中有没有用户信息(当然要对登录的jsp和Servlet放行)
				String uri = req.getRequestURI();
				HttpSession session = req.getSession();
				Emp emp = (Emp) session.getAttribute("emp");
				if( uri.indexOf("login.jsp") >= 0 || uri.indexOf("loginServlet.servlet") >= 0 
					|| uri.indexOf("image.jsp") >= 0 || emp != null ){
					chain.doFilter(request, response);
				}else{
					resp.sendRedirect(req.getContextPath()+"/system/login.jsp");
				}
				
	}

	@Override
	public void destroy() {
		
	}

}
