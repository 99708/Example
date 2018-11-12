package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.Teacher;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.UserServiceImpl;
import com.google.gson.Gson;
/**
 * 	用户维护
 * userServlet.bjsxt?method=find
 * */
public class userServlet extends BaseServlet {
	UserService userService = new UserServiceImpl();
	public void find(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		//获取请求数据
		 String Strrid = request.getParameter("rid");
		 int rid = Integer.valueOf(Strrid);
		 String Strname = request.getParameter("name");
		 int i = Integer.valueOf(Strname);
		 String Str = request.getParameter("serchText");
		 if(rid==1){//学生
			 Student stu = userService.findStudentInfo(i,Str);
			 System.out.println(stu);
			 request.setAttribute("stu", stu);
			 request.getRequestDispatcher("system/userSerch.jsp").forward(request, response);;
		 }else if(rid==2){
			 Teacher tea =  userService.findTeacherInfo(i,Str);
			 System.out.println(tea);
			 request.setAttribute("tea", tea);
			 request.getRequestDispatcher("system/userSerch.jsp").forward(request, response);
		 }
		 
	}
	/**
	 * 添加用户
	 * @throws IOException 
	 * @throws ServletException 
	 * */
	public void add(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		//获取数据
		String Struname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String Strrid = request.getParameter("rid");
		System.out.println(Struname+pwd+name+Strrid);
		int uname = Integer.valueOf(Struname);
		int rid = Integer.valueOf(Strrid);
		//调用Service层
	
		if(rid==1){
						Student stu = new Student();
						stu.setSid(uname);
						stu.setPwd(pwd);
						stu.setSname(name);
						stu.setRid(rid);
						int i = userService.addUser(stu);
						if(i>0){
							request.setAttribute("i", i);
							request.getRequestDispatcher("system/userRegister.jsp").forward(request, response);
						}else if(i<0){
							request.setAttribute("i", i);
							request.getRequestDispatcher("system/userRegister.jsp").forward(request, response);
						}
		}else if(rid==2||rid==3){
				Teacher tea = new Teacher();
				tea.setTid(uname);
				tea.setPwd(pwd);
				tea.setTname(name);
				tea.setRid(rid);
				int i = userService.addUser(tea);
				if(i>0){
					request.setAttribute("i", i);
					request.getRequestDispatcher("system/userRegister.jsp").forward(request, response);
				}else if(i<0){
					request.setAttribute("i", i);
					request.getRequestDispatcher("system/userRegister.jsp").forward(request, response);
				}
		}
	}
	
	public void findUsers(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int rid = Integer.valueOf(request.getParameter("rid"));
		int name = Integer.valueOf(request.getParameter("name"));
		String searchText = request.getParameter("searchText");
		Gson gson = new Gson();
		String json = null;
		if(rid==1){
			List<Student> student = userService.findStudents(name,searchText);
			json = gson.toJson(student);
		}else{
			List<Teacher> teacher = userService.findTeachers(name,searchText);
			json = gson.toJson(teacher);
		}
		response.getWriter().println(json);
	}
	
	public void updatePwd(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int id = Integer.valueOf(request.getParameter("id"));
		String pwd = request.getParameter("pwd");
		Student student = (Student)request.getSession().getAttribute("stu");
		//Teacher teacher = (Teacher)request.getSession().getAttribute("tea");
		int num = -1;
		if(student!=null){
			num = userService.updateStudentPwd(id,pwd);
		}else{
			num = userService.updateTeacherPwd(id,pwd);
		}
		String str = null;
		if(num>0){
			str = "修改成功";
		}else{
			str = "修改失败";
		}
		response.getWriter().println(str);
	}
}
