package com.xyq.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyq.entity.Dept;
import com.xyq.entity.Emp;
import com.xyq.entity.Position;
import com.xyq.service.DeptService;
import com.xyq.service.EmpService;
import com.xyq.service.PositionService;
import com.xyq.service.impl.DeptServiceImpl;
import com.xyq.service.impl.EmpServiceImpl;
import com.xyq.service.impl.PositionServiceImpl;
import com.xyq.util.TransUtil;


public class EmpServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	/**
	 * 查询所有
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findEmpList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//调用service层的方法
		EmpService empService = new EmpServiceImpl();
		List<Emp> empList = empService.findEmpList();
		//2、查询部门信息
		DeptService deptService = new DeptServiceImpl();
		List<Dept> deptList = deptService.findDept();
		//跳转
		req.setAttribute("empList", empList);
		req.setAttribute("deptList", deptList);
		req.getRequestDispatcher("/emp/empList.jsp").forward(req, resp);
	}
	/**
	 * 删除员工
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获取请求信息
		String empid = req.getParameter("empid");
		//调用service层的方法
		EmpService empService = new EmpServiceImpl();
		int num = empService.deleteEmp(empid);
		//跳转
		if(num != -1){
			findEmpList(req, resp);
		}else{
			req.setAttribute("error", "删除失败");
			req.getRequestDispatcher("/emp/empList.jsp").forward(req, resp);
		}
		
	}
	
	/**
	 * 在插入之前查询该公司的所有部门、领导、岗位信息用于在下拉框中显示
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void beforeAddEmpList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//调用service层的方法
		
		//1、查询领导信息
		EmpService empService = new EmpServiceImpl();
		List<Emp> mgrEmpList = empService.findMgrEmpList();
		
		//2、查询部门信息
		DeptService deptService = new DeptServiceImpl();
		List<Dept> deptList = deptService.findDept();
		
		//3、查询岗位信息
		PositionService positionService = new PositionServiceImpl();
		List<Position> positionList = positionService.findPositionList();
		
		//跳转
		req.setAttribute("mgrEmpList", mgrEmpList);
		req.setAttribute("deptList", deptList);
		req.setAttribute("positionList", positionList);
		
		req.getRequestDispatcher("/emp/empAdd.jsp").forward(req, resp);
	}
	/**
	 * 添加员工
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//获取请求信息
		String empid = req.getParameter("empid");
		String realname = req.getParameter("realname");
		String sex = req.getParameter("sex");
		String phone = req.getParameter("phone");
		String qq = req.getParameter("qq");
		String emercontactperson = req.getParameter("emercontactperson");
		String idcard = req.getParameter("idcard");
		
		String ondutyStr = req.getParameter("onduty");//int 
		int onduty = 0;
		if(ondutyStr != null && !"".equals(ondutyStr)){
			onduty = TransUtil.str2int(ondutyStr);
		}
		
		String emptypeStr = req.getParameter("emptype");//int 
		int emptype = 0;
		if(emptypeStr != null && !"".equals(emptypeStr)){
			emptype = TransUtil.str2int(emptypeStr);
		}
		
		String birthdateStr = req.getParameter("birthdate"); //Date
		Date birthdate = null;
		if(birthdateStr != null && !"".equals(birthdateStr)){
			birthdate = TransUtil.str2date(birthdateStr);
		}
		String hiredateStr = req.getParameter("hiredate"); //Date
		Date hiredate = null;
		if(hiredateStr != null && !"".equals(hiredateStr)){
			hiredate = TransUtil.str2date(hiredateStr);
		}
		
		String deptnoStr = req.getParameter("deptno");
		int deptno = 0;
		if(deptnoStr != null && !"".equals(deptnoStr)){
			deptno = TransUtil.str2int(deptnoStr);
		}
		String posidStr = req.getParameter("posid");
		int posid = 0;
		if(posidStr != null && !"".equals(posidStr)){
			posid = TransUtil.str2int(posidStr);
		}
		
		String mgrid = req.getParameter("mgrempid");
		Emp mgrEmp = new Emp();
		mgrEmp.setEmpid(mgrid);
		
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		
		Position position = new Position();
		position.setPosid(posid);
		
		Emp emp = new Emp(empid, realname, sex, birthdate, hiredate, onduty, emptype, phone, qq, emercontactperson, idcard, dept, position, mgrEmp);
		//调用service层的方法
		EmpService empService = new EmpServiceImpl();
		int num = empService.addEmp(emp);
		//跳转
		if(num != -1){
			findEmpList(req, resp);
		}else{
			req.setAttribute("error", "添加失败");
			beforeAddEmpList(req, resp);
		}
		
	}
	/**
	 * 展示详细信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获取请求信息
		String empid = req.getParameter("empid");
		//调用service层的方法
		EmpService empService = new EmpServiceImpl();
		Emp showEmp = empService.showEmp(empid);
		//跳转
		req.setAttribute("showEmp", showEmp);
		req.getRequestDispatcher("/emp/empInfo.jsp").forward(req, resp);
	}
	/**
	 * 修改之前查询要修改的员工信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateEmpQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//获取请求信息
		String empid = req.getParameter("empid");
		
		//调用service层的方法
		EmpService empService = new EmpServiceImpl();
		Emp showEmp = empService.showEmp(empid);
		
		//查询领导信息
		List<Emp> mgrEmpList = empService.findMgrEmpList();
		
		//查询部门信息
		DeptService deptService = new DeptServiceImpl();
		List<Dept> deptList = deptService.findDept();
		
		//查询岗位信息
		PositionService positionService = new PositionServiceImpl();
		List<Position> positionList = positionService.findPositionList();
		
		//跳转
		req.setAttribute("mgrEmpList", mgrEmpList);
		req.setAttribute("deptList", deptList);
		req.setAttribute("positionList", positionList);
		req.setAttribute("showEmp", showEmp);
		req.getRequestDispatcher("/emp/empUpdate.jsp").forward(req, resp);
	}
	
	/**
	 * 修改员工信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//获取请求信息
		String empid = req.getParameter("empid");
		String realname = req.getParameter("realname");
		String phone = req.getParameter("phone");
		String qq = req.getParameter("qq");
		String emercontactperson = req.getParameter("emercontactperson");
		String idcard = req.getParameter("idcard");
		
		String ondutyStr = req.getParameter("onduty");//int 
		int onduty = 0;
		if(ondutyStr != null && !"".equals(ondutyStr)){
			onduty = TransUtil.str2int(ondutyStr);
		}
		
		String birthdateStr = req.getParameter("birthdate"); //Date
		Date birthdate = null;
		if(birthdateStr != null && !"".equals(birthdateStr)){
			birthdate = TransUtil.str2date(birthdateStr);
		}
		String hiredateStr = req.getParameter("hiredate"); //Date
		Date hiredate = null;
		if(hiredateStr != null && !"".equals(hiredateStr)){
			hiredate = TransUtil.str2date(hiredateStr);
		}
		
		String leavedateStr = req.getParameter("leavedate"); //Date
		Date leavedate = null;
		if(leavedateStr != null && !"".equals(leavedateStr)){
			leavedate = TransUtil.str2date(leavedateStr);
		}
		
		String deptnoStr = req.getParameter("deptno");
		int deptno = 0;
		if(deptnoStr != null && !"".equals(deptnoStr)){
			deptno = TransUtil.str2int(deptnoStr);
		}
		String posidStr = req.getParameter("posid");
		int posid = 0;
		if(posidStr != null && !"".equals(posidStr)){
			posid = TransUtil.str2int(posidStr);
		}
		
		String mgrid = req.getParameter("mgrempid");
		Emp mgrEmp = new Emp();
		mgrEmp.setEmpid(mgrid);
		
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		
		Position position = new Position();
		position.setPosid(posid);
		
		Emp emp = new Emp(empid, realname, mgrid, birthdate, hiredate, leavedate, onduty, phone, qq, emercontactperson, idcard, dept, position, mgrEmp);
		//调用service层的方法
		EmpService empService = new EmpServiceImpl();
		int num = empService.updateEmp(emp);
		//跳转
		if(num != -1){
			findEmpList(req, resp);
		}else{
			req.setAttribute("empid", empid);
			req.setAttribute("error", "修改失败");
			updateEmpQuery(req, resp);
		}
	}
	
	public void findEmpListByArgs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获取请求信息
		String empid = req.getParameter("empid");
		
		String deptnoStr = req.getParameter("deptno");
		int deptno = TransUtil.str2int(deptnoStr);
		String ondutyStr = req.getParameter("onduty");
		int onduty = TransUtil.str2int(ondutyStr);
		
		String hiredateStr = req.getParameter("hiredate");
		Date hiredate = TransUtil.str2date(hiredateStr);
		//调用service层的方法
		EmpService empService = new EmpServiceImpl();
		List<Emp> empList = empService.findEmpListByArgs(empid , deptno, onduty, hiredate);
		//2、查询部门信息
		DeptService deptService = new DeptServiceImpl();
		List<Dept> deptList = deptService.findDept();
		//跳转
		req.setAttribute("empList", empList);
		req.setAttribute("deptList", deptList);
		req.getRequestDispatcher("/emp/empList.jsp").forward(req, resp);
	}
}
