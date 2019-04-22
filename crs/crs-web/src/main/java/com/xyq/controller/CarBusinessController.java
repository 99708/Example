package com.xyq.controller;

import com.xyq.entity.*;
import com.xyq.service.CarOperService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class CarBusinessController {
	
	//声明汽车操作Service属性
	@Resource
	private CarOperService carOperServiceImpl;
	
	//检测客户是否存在
	@ResponseBody
	@RequestMapping("checkIdcard")
	public String checkIDCardCon(HttpServletResponse resp , String idcard){
		Customer cust = carOperServiceImpl.selectCustomerByIdcardServie(idcard);
		if(cust != null){
			return "true";
		}else {
			return "false";
		}

	}
	
	//如果客户存在 客户在才能进来的方法，客户选车页面
	@RequestMapping("rentCar")
	public String rentCarCon(String idcard , HttpServletRequest req){
		
		//查询为用户推荐车型
		List<Car> carList = carOperServiceImpl.selectCarByStatusService("未出租");
		req.setAttribute("carList", carList);
		req.setAttribute("idcard", idcard);
		return "operatorManager/showCar";
	}

	/**
	 * 跳转到生成出租单界面
	 * @param idcard
	 * @param carid
	 * @param req
	 * @return
	 */
	@RequestMapping("rentCarNow")
	public String renCarByIdCard(String idcard , Integer carid , HttpServletRequest req){
		
		//根据ID查询汽车信息
		Car car = carOperServiceImpl.selectCarByIdService(carid);
		//生成动态订单号
		long ct = System.currentTimeMillis();
		long ctime = ct - 1542000000000L;
		String tableId = String.valueOf(ctime).substring(0,9);
		//将数据返回到前端页面
		req.setAttribute("car", car);
		req.setAttribute("tableId", tableId);
		req.setAttribute("idcard", idcard);
		return "operatorManager/preCreateRenting";
	}

	/**
	 * 生成出租单
	 * @param rt
	 * @param req
	 * @return
	 */
	@RequestMapping("rentCarByIdCard")
	public String rentCarByIdCardCon(Rental rt , HttpServletRequest req){
		
		//获取操作人员信息
		User user = (User)req.getSession().getAttribute("user");
		//设置操作符
		String oper = "填写出租单信息";
		//获取当前时间(操作时间)
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String opertime = df.format(new Date());// new Date()为获取当前系统时间
		//设置日志状态为存在
        Integer status = 0;
        //设置该次操默认成功
		String success = "成功";

		try {
			//插入出租单信息
			carOperServiceImpl.insertCarRentService(rt);
			//修改该汽车状态
			carOperServiceImpl.updateCarStatusByCarid(rt.getStatus(), rt.getCarid());
			//记录日志
			carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, status, success);
			//
			return "operatorManager/rentManager";
		} catch (Exception e) {
			e.printStackTrace();
			//记录日志
			carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, status, "生成出租单失败"+e.getCause());
			return "carManager/failed";
		}

	}
	
	//ajax的根据出租单校验存在性
	@ResponseBody
	@RequestMapping("returnCar")
	public String returnCarCheck(Integer rentid){
		
		//查询出租单
		Rental rt = carOperServiceImpl.selectOneRentalByRentidService(rentid);
		//判断是否查询到
		if(rt != null){
			return "true";
		}
		return "false";
	}
	
	/**
	 * 如果客户过来还车，提供检查单
	 * @param rentid
	 * @return
	 */
	@RequestMapping("returnCarNow")
	public String returnCarNowCon(Integer rentid , HttpServletRequest req){
		
		//生成动态检查单号
		long ct = System.currentTimeMillis();
		long checkid = ct - 1542000000000L;
		//生成当前时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String checkDate = df.format(new Date());
		
		//通过rentid获取相关联的idcard和carid
		String idcard = carOperServiceImpl.selectIdcardByRentidService(rentid);
		Integer carid = carOperServiceImpl.selectCaridByRentidService(rentid);
		
		//通过idcard和carid获取相关联数据
		Car car = carOperServiceImpl.selectOneCarByCaridService(carid);
		Customer cust = carOperServiceImpl.selectOneCustByIdcardService(idcard);
		//获取出租单信息
		Rental rent = carOperServiceImpl.selectOneRentalByRentidService(rentid);
		String uname = carOperServiceImpl.selectUnameByUidService(rent.getUid());
		
		//将数据传给前端
		req.setAttribute("uname", uname);
		req.setAttribute("checkid", checkid);
		req.setAttribute("checkDate", checkDate);
		req.setAttribute("car", car);
		req.setAttribute("cust", cust);
		req.setAttribute("rent", rent);
		
		return "operatorManager/createCheckTable";
	}
	
	@RequestMapping("makeNewCheckAndReturnCar")
	public String makeNewCheckAndReturnCarNow(HttpServletRequest req){
		
		//获取操作人id
		//默认是张三
		
		//设置操作符
		String oper = "添加汽车信息";
		//获取当前时间(操作时间)
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String opertime = df.format(new Date());// new Date()为获取当前系统时间
		//设置日志状态为存在
        Integer status = 0;
        //设置该次操默认成功
		String success = "成功";
		
		//获取前端主键数据
		String rentidStr = req.getParameter("rentid");  //出租单号(需要修改)
		Integer rentid = 10000000;
		String caridStr = req.getParameter("carid");	//汽车编号(需要修改)
		Integer carid = 1001;
		String uidStr = req.getParameter("uid");		//操作员ID
		Integer uid = 10000;
		
		if(!"".equals(rentidStr) && rentidStr != null){
			rentid = Integer.parseInt(rentidStr); //出租单号
		}
		if(!"".equals(caridStr) && caridStr != null){
			carid = Integer.parseInt(caridStr); //汽车编号
		}
		if(!"".equals(uidStr) && uidStr != null){
			uid = Integer.parseInt(uidStr);  //操作员编号
		}
		
		//获取前端检查单插入数据
		String checkidStr = req.getParameter("checkid"); 	//检查单号
		Integer checkid = 20000000;
		if(checkidStr != null && !"".equals(checkidStr)){
			checkid = Integer.parseInt(checkidStr);
		}
		
		String checkdate = req.getParameter("checkdate");	//检查时间
		String problem = req.getParameter("problem");  //问题 
		
		String payStr = req.getParameter("pay");      //赔款
		Double pay = 0.0;
		if(payStr != null && !"".equals(payStr)){
			pay = Double.parseDouble(payStr);
		}
		
		//创建 检查单对象
		Checked ck = new Checked();
		ck.setCheckid(checkid);
		ck.setCheckdate(checkdate);
		ck.setProblem(problem);
		ck.setPay(pay);
		ck.setUid(uid);
		ck.setRentid(rentid);
		
		System.out.println(ck);
		//插入一条检查单数据
		int num = carOperServiceImpl.insertOneCheckedService(ck);
		int num2 = carOperServiceImpl.updateStatusByCaridAndRentId("未出租", rentid, carid);
		if(num > 0 && num2 >0){
			//插入日志信息
			int num3 = carOperServiceImpl.insertIntoSlfService(uid, oper, opertime, status, success);
			if(num3 > 0){
				System.out.println(opertime);
				System.out.println("插入日志成功!");
			}
			return "carManager/OK";
		}
		//插入日志信息，操作失败
		success = "失败";
		int num4 = carOperServiceImpl.insertIntoSlfService(uid, oper, opertime, status, success);
		if(num4 > 0){
			System.out.println(opertime);
			System.out.println("插入日志成功,但是操作失败了!");
		}
		return "carManager/failed";
	}

}
