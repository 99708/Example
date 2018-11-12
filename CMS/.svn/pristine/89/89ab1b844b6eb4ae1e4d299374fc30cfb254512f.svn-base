package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.Teacher;
import com.bjsxt.service.LoginService;
import com.bjsxt.service.impl.LoginServiceImpl;
import com.bjsxt.pojo.Menu;
/**
 * loginServlet.bjsxt?method=login
 * 用户登陆
 * 
 * */
public class loginServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	/**
	 * 退出
	 * */
	public void out(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//session解除对象绑定
		HttpSession session = request.getSession();
		session.invalidate();
		//重定向到login.jsp页面
		response.sendRedirect(request.getContextPath() +"/system/login.jsp");
	}
	/**
	 * 登陆
	 * */
	public void login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			//获取请求数据
		 	String uname = request.getParameter("userName");
		 	String pwd = request.getParameter("password");
		 	String Strrid = request.getParameter("rid");
		 	String verify = request.getParameter("verify");
		 	HttpSession session = request.getSession();
		    String verifyCode = session.getAttribute("rand").toString();    
		 	//测试是否获取数据
		 	int rid= Integer.parseInt(Strrid);//格式转为int
		 	//调用serivce层进行登陆校验
		 	LoginService loginService = new LoginServiceImpl();
		 	if(verifyCode.equalsIgnoreCase(verify)){
		 		if(rid==1){//学生
			 		Student stu = loginService.getStudentInfo(uname,pwd);
			 	 	if(stu.getSid()!=null){
			 	 		List<Menu> lm=loginService.getMenuInfo(stu.getRid()); 
						session.setAttribute("lm", lm);
			 	 		session.setAttribute("rid", rid);
				 		session.setAttribute("stu", stu);	
				 		request.getRequestDispatcher("/system/main.jsp").forward(request, response);
			 	 	}	else{//失败跳转到登录页面
			 	 		request.setAttribute("error_name","账号密码不正确");
				 		request.getRequestDispatcher("/system/login.jsp").forward(request, response);
				 	}
			 	}else if(rid==2){//老师
			 		Teacher tea = loginService.getTeacherInfo(uname,pwd,rid);
			 		if(tea.getTid()!=null){
			 			System.out.println(tea);
			 			List<Menu> lm=loginService.getMenuInfo(tea.getRid()); 
			 			session.setAttribute("lm", lm);
			 			session.setAttribute("rid", rid);
			 			session.setAttribute("tea", tea);	
				 		request.getRequestDispatcher("/system/main.jsp").forward(request, response);
			 	 	}	else{//失败跳转到登录页面
			 	 		request.setAttribute("error_name","账号密码不正确");
				 		request.getRequestDispatcher("/system/login.jsp").forward(request, response);
			 		}
			 	}else if(rid==3){//管理员
			 		Teacher tea = loginService.getTeacherInfo(uname,pwd,rid);
			 		if(tea.getTid()!=null){
			 			System.out.println(tea);
			 			List<Menu> lm=loginService.getMenuInfo(tea.getRid()); 
			 			session.setAttribute("lm", lm);
			 			session.setAttribute("rid", rid);
			 			session.setAttribute("tea", tea);	
				 		request.getRequestDispatcher("/system/main.jsp").forward(request, response);
			 	 	}	else{//失败跳转到登录页面
			 	 		request.setAttribute("error_name","账号密码不正确");
				 		request.getRequestDispatcher("/system/login.jsp").forward(request, response);
			 		}
			 	}
		 	}else{//验证码错误
				request.setAttribute("error","验证码错误");
				request.getRequestDispatcher("/system/login.jsp").forward(request, response);
		 	}		 		
	}
}
