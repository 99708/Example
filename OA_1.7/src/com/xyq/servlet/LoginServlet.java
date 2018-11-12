package com.xyq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xyq.entity.Emp;
import com.xyq.service.LoginService;
import com.xyq.service.impl.LoginServiceImpl;


public class LoginServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 登录处理
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		HttpSession session = req.getSession();
		//获取请求数据
		String empid = req.getParameter("empid");
		String password = req.getParameter("password");
		String verify = req.getParameter("verify");
		//登录验证
			//获取系统生成的验证码
			String verify2 = (String) session.getAttribute("rand");
			if(!"".equals(verify) && verify != null && verify2.equalsIgnoreCase(verify)){
				//到数据库中查找这个人
				//调用service层的方法
				LoginService loginService = new LoginServiceImpl();
				Emp emp = loginService.login(empid, password);
				//如果结果不为空跳转到main.jsp界面
				if(emp != null){
					session.setAttribute("emp", emp);
					resp.sendRedirect(req.getContextPath()+"/system/main.jsp");
				}else{//如果为空反馈信息
					req.setAttribute("error_name", "密码或用户名错误");
					req.getRequestDispatcher("/system/login.jsp").forward(req, resp);
				}
			}else{//反馈验证码错误
				req.setAttribute("error", "验证码错误");
				req.getRequestDispatcher("/system/login.jsp").forward(req, resp);
			}
		
	}
	
	/**
	 * 退出登录并使session无效
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void loginOut(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect(req.getContextPath()+"/system/login.jsp");
	}
	
	
}
