package com.xyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyq.entity.Dept;
import com.xyq.service.DeptService;
import com.xyq.service.impl.DeptServiceImpl;


public class DeptServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	public void findDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		DeptService deptService = new DeptServiceImpl();
		List<Dept> deptList = deptService.findDept();
		req.setAttribute("deptList", deptList);
		req.getRequestDispatcher("/dept/deptList.jsp").forward(req, resp);
	}
	
	public void addDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获取请求数据
		int deptid = 0;
		String deptno = req.getParameter("deptno");
		if(!"".equals(deptno)){
			deptid = Integer.valueOf(deptno);
			String deptname = req.getParameter("deptname");
			String location = req.getParameter("location");
			//调用service层
			Dept dept = new Dept(deptid, deptname, location);
			DeptService deptService = new DeptServiceImpl();
			int num = deptService.addDept(dept);
			if(num != -1){
				findDept(req, resp);
			}else{
				req.setAttribute("error", "添加失败！");
				req.getRequestDispatcher("/dept/deptAdd.jsp").forward(req, resp);
			}
		}else{
			req.setAttribute("error", "添加失败！");
			req.getRequestDispatcher("/dept/deptAdd.jsp").forward(req, resp);
		}
	}
	
	public void deleteDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获取请求数据
		String deptno = req.getParameter("deptno");
		if(!"".equals(deptno)){
			int deptid = Integer.valueOf(deptno);
			DeptService deptService = new DeptServiceImpl();
			int num = deptService.deleteDept(deptid);
			if(num != -1){
				findDept(req, resp);
			}else{
				req.setAttribute("error", "删除失败！");
				req.getRequestDispatcher("/dept/deptList.jsp").forward(req, resp);
			}
		}else{
			req.setAttribute("error", "删除失败！");
			req.getRequestDispatcher("/dept/deptList.jsp").forward(req, resp);
		}
	}
	
	public void updateQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获取请求信息
		String deptno = req.getParameter("deptno");
		if(!"".equals(deptno)){
			int deptid = Integer.valueOf(deptno);
			DeptService deptService = new DeptServiceImpl();
			Dept dept = deptService.updateQuery(deptid);
			if(dept != null){
				req.setAttribute("dept", dept);
				req.getRequestDispatcher("/dept/deptUpdate.jsp").forward(req, resp);
			}else{
				req.setAttribute("error", "修改失败！");
				req.getRequestDispatcher("/dept/deptList.jsp").forward(req, resp);
			}
		}else{
			req.setAttribute("error", "修改失败！");
			req.getRequestDispatcher("/dept/deptList.jsp").forward(req, resp);
		}
	}
	
	public void updateDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获取请求数据
		int deptid = 0;
		String deptno = req.getParameter("deptno");
		if(!"".equals(deptno)){
			deptid = Integer.valueOf(deptno);
			String deptname = req.getParameter("deptname");
			String location = req.getParameter("location");
			//调用service层
			Dept dept = new Dept(deptid, deptname, location);
			DeptService deptService = new DeptServiceImpl();
			int num = deptService.updateDept(dept);
			if(num != -1){
				findDept(req, resp);
			}else{
				req.setAttribute("error", "修改失败！");
				req.setAttribute("deptno", deptno);
				updateQuery(req, resp);
			}
		}else{
			req.setAttribute("error", "修改失败！");
			req.setAttribute("deptno", deptno);
			updateQuery(req, resp);
		}
	}

}
