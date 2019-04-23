package com.xyq.controller;

import com.xyq.entity.*;
import com.xyq.service.CarOperService;
import com.xyq.service.RentalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class RentalController {

	@Resource
	private RentalService rentalServiceImpl;

	@Resource
	private CarOperService carOperServiceImpl;

	/**
	 * 按条件分页查询出租单信息
	 * @param rental
	 * @param customer
	 * @param pageNum
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping("selRental")
	public RentalPage selRental(Rental rental, Customer customer, Integer pageNum, Integer pageSize, HttpServletRequest req){

		//获取操作人员信息
		User user = (User)req.getSession().getAttribute("user");
		//设置操作符
		String oper = "查询出租单信息";
		//获取当前时间(操作时间)
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String opertime = df.format(new Date());// new Date()为获取当前系统时间
		//设置日志状态为存在
		Integer status = 0;
		//设置该次操默认成功
		String success = "成功";

		try {
			RentalPage rentalPage = rentalServiceImpl.selRentalBySomeCondition(rental, customer, pageNum, pageSize);
			//记录日志
			carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, status, success);
			return rentalPage;
		} catch (Exception e) {
			e.printStackTrace();
			//记录日志
			carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, status, "查询出租单信息失败"+e.getCause());
			return null;
		}
	}
	
	/**
	 * 根据出租单号查找出租信息
	 * @param rentid
	 * @param request
	 * @return
	 */
	@RequestMapping("selRentalByRentid")
	public String selRentalByRentid(int rentid,String idcard,int carid,HttpServletRequest request){
		Rental rental = rentalServiceImpl.selRentalByRentid(rentid);
		Customer customer = rentalServiceImpl.selCustomerByIdcard(idcard);
		Car car = rentalServiceImpl.selCarByCarid(carid);
		
		User user = (User) request.getSession().getAttribute("user");
		int uid2 = user.getUid();
		rentalServiceImpl.insertSlfInfo(uid2, "查询编号为"+rentid+"出租单详细信息", "成功");
		
		request.setAttribute("rental", rental);
		request.setAttribute("customer", customer);
		request.setAttribute("car", car);
		return "operatorManager/updateRenttable";
	}
	
	/**
	 * 修改车辆状态信息以及出租单信息
	 * @param rental
	 * @return
	 */
	@RequestMapping("updateAllStatus")
	public String updateAllStatus(Rental rental,int rentid,String idcard,int carid,HttpServletRequest request){
		int num = rentalServiceImpl.updateAllStatus(carid, rental);
		User user = (User) request.getSession().getAttribute("user");
		int uid2 = user.getUid();
		if(num==2){
			rentalServiceImpl.insertSlfInfo(uid2, "修改编号为"+rentid+"的出租单详细信息", "成功");
			request.setAttribute("info", "修改成功");
		}else{
			rentalServiceImpl.insertSlfInfo(uid2, "修改编号为"+rentid+"的出租单详细信息", "成功");
			request.setAttribute("info", "修改失败");
		}	
		return "forward:/selRentalByRentid";
	}
}
