package com.bjsxt.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.CusPage;
import com.bjsxt.pojo.Customer;
import com.bjsxt.service.CustomersService;

@Controller
public class CustomersController {
		@Resource
		private CustomersService customersService;
		/**
		 * 校验用户
		 */
		@ResponseBody
		@RequestMapping("selCusByIdcard")
		public String selCusByIdcard(String idcard){
			Customer cus = customersService.selCusByIdcard(idcard);
			if(cus!=null){
				return "false";
			}else{
				return "true";
			}
			
		}
		
		/**
		 * 修改密码
		 * @param idcard
		 * @param oldPwd
		 * @param newPwd
		 * @return
		 */
		@RequestMapping("upCusPwd")
		public String upCusPwd(String idcard,String oldPwd,String newPwd){
			System.out.println(idcard+"---"+oldPwd+"----"+newPwd);
			int i = customersService.upCusPwd(idcard, oldPwd, newPwd);
			if(i>0){
				return "forward:/ok.jsp";
			}else{
				return "forward:/error.jsp";
			}
		}
		
		/**
		 * 跳转到修改密码页面
		 * @param idcard
		 * @param pwd
		 * @param req
		 * @return
		 */
		@RequestMapping("changePwd")
		public String changePwd(String idcard,String pwd,HttpServletRequest req){
			req.setAttribute("idcard", idcard);
			req.setAttribute("pwd", pwd);
			return "custManager/chengeCustomersPwd";
		}
		/**
		 * 删除客户信息
		 * @param idcard
		 * @return
		 */
		@RequestMapping("delCus")
		public String delCus(String idcard){
			int i = customersService.delCus(idcard);
			if(i>0){
				return "forward:/ok.jsp";
			}else{
				return "forward:/error.jsp";
			}
		}
		/**
		 * 修改客户信息
		 * @param cus
		 * @return
		 */
		@RequestMapping("upCus")
		public String upCus(Customer cus){
			int i = customersService.upCus(cus);
			if(i>0){
				return "forward:/ok.jsp";
			}else{
				return "forward:/error.jsp";
			}
		}
		/**
		 * 根据idcard查询客户信息
		 * @param idcard
		 * @param req
		 * @return
		 */
		@RequestMapping("selOneCus")
		public String selOneCus(String idcard,HttpServletRequest req){
			
			Customer cus = customersService.selOneCus(idcard);
			req.setAttribute("cus", cus);
			return "custManager/updateCustomers";
		}
		/**
		 * 分页查询客户信息
		 * @param cus
		 * @param pageNum
		 * @param req
		 * @return
		 */
		@RequestMapping("selCus")
		public String selCus(Customer cus,int pageNum,HttpServletRequest req){
			CusPage cp = customersService.selCus(cus, pageNum);
			req.setAttribute("cus", cus);
			req.setAttribute("cp", cp);
			return "custManager/viewCustomers";
		}
		/**
		 * 添加客户
		 * @param cus
		 * @return
		 */
		@RequestMapping("addCustomers")
		public String insCus(Customer cus){
			int i = customersService.insCus(cus);
			if(i>0){
				return "forward:/ok.jsp";
			}else{
				return "forward:/error.jsp";
			}
		}
}
