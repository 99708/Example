package com.bjsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 编码过滤器
 * @company sxt
 * @author fangyl
 * @Date 2018年10月17日
 *
 */
public class EncodFilter implements Filter {
	String encode = "utf-8";

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
			//设定请求和响应的编码集
		request.setCharacterEncoding(encode);
		response.setCharacterEncoding(encode);
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		 encode = filterConfig.getInitParameter("encode");
		System.out.println(encode);
	}

}
