package com.xyq.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.xyq.entity.Emp;
import com.xyq.entity.Expense;
import com.xyq.entity.ExpenseItem;
import com.xyq.service.ExpenseService;
import com.xyq.service.impl.ExpenseServiceImpl;
import com.xyq.util.TransUtil;
import com.xyq.vo.MsgVo;


public class ExpenseServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	//添加报销单之前的查询
	public void beforeAddExpense(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//获得当前登录者的信息
		HttpSession session = req.getSession();
		Emp emp = (Emp) session.getAttribute("emp");
		String empid = emp.getEmpid();
		//根据empid获取直属上级信息
		ExpenseService expenseService = new ExpenseServiceImpl();
		Emp mgrEmp = expenseService.beforeAddExpenseQuery(empid);
		
		//获取当前时间
		Date nowDate = new Date();
		String nowDateStr = TransUtil.date2str(nowDate);
		//响应到前台页面
		req.setAttribute("mgrEmp", mgrEmp);
		req.setAttribute("nowDateStr", nowDateStr);
		req.setAttribute("empid", empid);
		req.getRequestDispatcher("expense/expenseAdd.jsp").forward(req, resp);
		
	}
	
	public void addExpense(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//获取用户信息
		HttpSession session = req.getSession();
		Emp emp = (Emp) session.getAttribute("emp");
		//获取请求信息
		String exptimeStr = req.getParameter("exptime");
		Date str2date = TransUtil.str2date(exptimeStr);
		java.sql.Date exptime = TransUtil.utildate2SQLDate(str2date);
		String totalamountStr = req.getParameter("totalamount");
		Double totalamount = 0.0;
		if(totalamountStr != null && !"".equals(totalamountStr)){
			totalamount = Double.valueOf(totalamountStr);
		}
		String nextauditor = req.getParameter("nextauditor");
		String expdesc = req.getParameter("expdesc");
		
		//获取报销详情
		String[] typeArr = req.getParameterValues("type");
		String[] amountArr = req.getParameterValues("amount");
		String[] itemdescArr = req.getParameterValues("itemdesc");
		
		List<ExpenseItem> expenseItemList = new ArrayList<ExpenseItem>();
		
		for(int i=0; i<typeArr.length; i++){
			ExpenseItem expenseItem = new ExpenseItem();
			expenseItem.setType(typeArr[i]);
			if(amountArr[i] != null && !"".equals(amountArr[i])){
				expenseItem.setAmount(Double.valueOf(amountArr[i]));
			}
			expenseItem.setItemdesc(itemdescArr[i]);
			expenseItemList.add(expenseItem);
		}
		Expense expense = new Expense(emp, totalamount, exptime, expdesc, nextauditor, "1", expenseItemList);
		//调用service层的方法
		ExpenseService expenseService = new ExpenseServiceImpl();
		
		MsgVo msgVo = null;
		
		try {
			expenseService.addExpense(expense);
			msgVo = new MsgVo(1, "添加成功");
		} catch (Exception e) {
			msgVo = new MsgVo(0, "添加失败");
		}
		
		Gson gson = new Gson();
		String rsData = gson.toJson(msgVo);
		
		resp.setContentType("text/json");
		resp.getWriter().println(rsData);
		
	}
}
