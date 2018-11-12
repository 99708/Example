package com.bjsxt.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Classes;
import com.bjsxt.pojo.Major;
import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.StudentPage;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.impl.StudentServiceImpl;
import com.bjsxt.util.Date2str;
import com.google.gson.Gson;


public class StudentServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private StudentService studentService = new StudentServiceImpl();
	
	/**
	 * 查询当前登录的学生信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findMyInfo(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		Student stu =(Student) request.getSession().getAttribute("stu");
		Integer sid = stu.getSid();
		Student student = studentService.findMyInfoBySid(sid);
		int mid = student.getMajor().getMid();
		int cid = student.getClasses().getCid();
		Major major = studentService.findMajorByMid(mid);
		String cname = studentService.findCnameByCid(cid);
		student.setMajor(major);
		student.getClasses().setMajor(major);
		student.getClasses().setCname(cname);		
		
		request.setAttribute("student", student);
		request.getRequestDispatcher("/archives/studentInfo.jsp").forward(request, response);
	}
	
	public void findClasses(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<Classes> classesList = studentService.findAllClasses();
		Gson gson = new Gson();
		String json = gson.toJson(classesList);
		response.setContentType("text/json");
		response.getWriter().println(json);

	}
	
	/**
	 * 根据mid查询major
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void findMajor(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int cid = Integer.valueOf(request.getParameter("cid"));
		int mid = studentService.findMidByCid(cid);
		Major major = studentService.findMajorByMid(mid);
		Gson gson = new Gson();
		String json = gson.toJson(major);
		response.setContentType("text/json");
		response.getWriter().println(json);
	}
	
	/**
	 * 添加学生信息
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void addStudent(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
		int cid = Integer.valueOf(request.getParameter("classes"));
		int gcode = Integer.valueOf(request.getParameter("gcode"));
		String sname = request.getParameter("sname");
		String sex = request.getParameter("sex");
		int age = Integer.valueOf(request.getParameter("age"));
		String idcard = request.getParameter("idcard");
		Date birthdate = Date2str.str2date(request.getParameter("birthdate")) ;
		Date enterdate = Date2str.str2date(request.getParameter("enterdate"));
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String party = request.getParameter("party");
		String health = request.getParameter("health");
		String pwd = "123456";
		int rid = 1;
		
		int mid = studentService.findMidByCid(cid);
		Major major = new Major();
		major.setMid(mid);
		Classes classes = new Classes();
		classes.setCid(cid);
		
		Student student = new Student(pwd, rid, sname, sex, age, idcard, birthdate, party, phone, address, health, major, classes, gcode, enterdate);
		
		int num = studentService.addStudent(student);
		if(num>0){
			request.getRequestDispatcher("/archives/studentSearch.jsp").forward(request, response);
		}else{
			request.setAttribute("error","添加失败");
			request.getRequestDispatcher("/archives/studentReg.jsp").forward(request, response);
		}
	}
	
	/**
	 * 使用分页按条件筛选学生信息
	 * @param request
	 * @param response
	 */
	public void findStudents(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String sid = request.getParameter("sid");
		String cid = request.getParameter("cid");
		int num=Integer.parseInt(request.getParameter("num"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		StudentPage sp = studentService.findStudents(sid,cid,num,pageSize);
		Gson gson = new Gson();
		String json = gson.toJson(sp);
		response.getWriter().println(json);
	}
	
	/**
	 * 根据sid查询某个学生信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void findStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int sid = Integer.valueOf(request.getParameter("sid"));
		Student student = studentService.findStudentBySid(sid);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/archives/studentRevice.jsp").forward(request, response);
	}
	
	/**
	 * 修改学生信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void updateStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int sid = Integer.valueOf(request.getParameter("sid"));
		int cid = Integer.valueOf(request.getParameter("cid"));
		int mid = Integer.valueOf(request.getParameter("mid"));
		int age = Integer.valueOf(request.getParameter("age"));
		String party = request.getParameter("party");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String health = request.getParameter("health");
		
		Classes classes = new Classes();
		classes.setCid(cid);
		Major major = new Major();
		major.setMid(mid);
		Student student = new Student(sid, age, party, phone, address, health, major, classes);
		int num = studentService.updateStudent(student);
		if(num>0){
			request.getRequestDispatcher("/archives/studentSearch.jsp").forward(request, response);
		}else{
			request.setAttribute("error","修改失败");
			request.getRequestDispatcher("/archives/studentRevice.jsp").forward(request, response);
		}
	}
	
	/**
	 * 根据cid查找年级
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void findGcode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int cid = Integer.valueOf(request.getParameter("cid"));
		int gcode = studentService.findGcodeByCid(cid);
		response.getWriter().println(new Gson().toJson(gcode));
	}
}
