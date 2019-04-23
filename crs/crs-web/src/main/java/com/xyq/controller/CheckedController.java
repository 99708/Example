package com.xyq.controller;

import com.xyq.entity.*;
import com.xyq.service.CheckedService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
public class CheckedController {
	
	@Resource
	private CheckedService checkedServiceImpl;
	
	/**
	 * 按条件分页查询检查单信息
	 * @param checkid
	 * @param checkdate
	 * @param uname
	 * @param rentid
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @return
	 */
	@RequestMapping("selChecked")
	public String selChecked(String checkid,String checkdate,String uname,String rentid,int pageNum, 
			int pageSize, HttpServletRequest request){
		CheckedPage checkedPage = checkedServiceImpl.selCheckedBySomeCondition(checkid, checkdate, uname, rentid, pageNum, pageSize);
		VagueChecked vagueChecked = new VagueChecked(checkid, checkdate, uname, rentid);
		
		User user = (User) request.getSession().getAttribute("user");
		int uid2 = user.getUid();
		checkedServiceImpl.insertSlfInfo(uid2, "查询检查单信息", "成功");
		request.getSession().setAttribute("checkedPage", checkedPage);
		request.getSession().setAttribute("vagueChecked", vagueChecked);
		
		return "operatorManager/viewCheckTables";
	}
	

	/**
	 *  根据检查单号查找检查信息
	 * @param uname
	 * @param checkid
	 * @param rentid
	 * @param request
	 * @return
	 */
	@RequestMapping("selCheckedByRentid")
	public String selCheckedByRentid(String uname,int checkid,int rentid,HttpServletRequest request ){
		Checked checked = checkedServiceImpl.selCheckedByCheckid(checkid);
		Rental rental = checkedServiceImpl.selRentalByRentid(rentid);
		User user = checkedServiceImpl.selUserByUname(uname);
		Car car = checkedServiceImpl.selCarByRentalCarid(rental);
		Customer customer = checkedServiceImpl.selCustomerByRentalIdcard(rental);
		
		User user2 = (User) request.getSession().getAttribute("user");
		int uid2 = user2.getUid();
		checkedServiceImpl.insertSlfInfo(uid2, "查询编号为"+checkid+"检查单信息", "成功");
		request.setAttribute("checked", checked);
		request.setAttribute("rental", rental);
		request.setAttribute("user", user);
		request.setAttribute("car", car);
		request.setAttribute("customer", customer);
		return "operatorManager/updateCheckTable";
	}
	
	/**
	 * 修改检查单信息
	 * @param checkid
	 * @param rentid
	 * @param uname
	 * @param problem
	 * @param pay
	 * @param request
	 * @return
	 */
	@RequestMapping("updateChecked")
	public String updateChecked(int checkid,int rentid,String uname,String problem,double pay,HttpServletRequest request){
		int num = checkedServiceImpl.updateChecked(checkid, problem, pay);
		
		User user2 = (User) request.getSession().getAttribute("user");
		int uid2 = user2.getUid();
		if(num>0){
			checkedServiceImpl.insertSlfInfo(uid2, "修改编号为"+checkid+"检查单信息", "成功");
			request.setAttribute("info", "修改成功");
		}else{
			checkedServiceImpl.insertSlfInfo(uid2, "查询编号为"+checkid+"检查单信息", "失败");
			request.setAttribute("info", "修改失败");
		}
		return "forward:/selCheckedByRentid";
	}
	
	@RequestMapping("deleteCheckedByCheckid")
	public String deleteCheckedByCheckid(int checkid,HttpServletRequest request){
		int num = checkedServiceImpl.deleteChecked(checkid);
		User user2 = (User) request.getSession().getAttribute("user");
		int uid2 = user2.getUid();
		if(num>0){
			checkedServiceImpl.insertSlfInfo(uid2, "删除编号为"+checkid+"检查单", "成功");
			request.setAttribute("info", "删除成功");
		}else{
			checkedServiceImpl.insertSlfInfo(uid2, "修改编号为"+checkid+"检查单信息", "失败");
			request.setAttribute("info", "删除失败");
		}
		return "operatorManager/checkManager";
	}
}
