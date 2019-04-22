package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.pojo.Car;
import com.bjsxt.pojo.CarPage;
import com.bjsxt.service.CarOperService;
import com.bjsxt.service.CarService;

@Controller
public class CarConMousepls {
	
	//声明汽车Service属性
	@Resource
	private CarService carServiceImpl; 
	@Resource
	private CarOperService carOperServiceImpl;
	
	/**
	 * 添加汽车租赁(跳转到页面)
	 * @return
	 */
	@RequestMapping("addCar")
	public String insertCarMethod(){
		return "carManager/addCar";
	}
	
	/**
	 * 添加汽车租赁的方法
	 * @param car
	 * @param file
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("addCarNow")
	public String insertCarNowMethod(Car car , MultipartFile file , HttpServletRequest req) throws IllegalStateException, IOException{
		
		//获取操作人id
		String uidStr = req.getParameter("uid");
		//默认是张三
		Integer uid = 10000;
		if(!"".equals(uidStr) && uidStr != null){
			uid = Integer.parseInt(uidStr);
		}
		//设置操作符
		String oper = "添加汽车信息";
		//获取当前时间(操作时间)
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String opertime = df.format(new Date());// new Date()为获取当前系统时间
		//设置日志状态为存在
        Integer status = 0;
        //设置该次操默认成功
		String success = "成功";
        
		//将附件储存到服务器硬盘
		//校验文件类型
		//获取文件名
		String fileName = file.getOriginalFilename();
		//获取文件后缀名
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		String uname = UUID.randomUUID()+"";
		fileName = uname.replace("-", "") + fileName;
		
		if(".jpg".equals(suffix) || ".png".equals(suffix) || ".gif".equals(suffix) || ".bmp".equals(suffix)){
			//动态获取项目下路径
			String path=req.getServletContext().getRealPath("/Car-photo");
			System.out.println(path);
			//写入文件
			file.transferTo(new File(path,fileName));
			car.setImg(fileName);
			int num = carServiceImpl.insertCarService(car);
			if(num > 0){
				int num2 = carOperServiceImpl.insertIntoSlfService(uid, oper, opertime, status, success);
				if(num2 > 0){
					System.out.println(opertime);
					System.out.println("插入日志成功!");
				}
				return "carManager/OK";
			}
		}
		success = "失败";
		int num3 = carOperServiceImpl.insertIntoSlfService(uid, oper, opertime, status, success);
		if(num3 > 0){
			System.out.println(opertime);
			System.out.println("插入日志成功,但是操作失败了!");
		}
		return "carManager/Failed";
	}
	
	/**
	 * 跳转到查询汽车页面
	 * @return
	 */
	@RequestMapping("findCar")
	public String selectCarMethod(){
		return "carManager/findCar";
	}
	
	/**
	 * 根据条件查询所有汽车
	 * @param req
	 * @return
	 */
	@RequestMapping("findCarNow")
	public String selectCarNow(HttpServletRequest req){
		
		//获取操作人id
		String uidStr = req.getParameter("uid");
		//默认是张三
		Integer uid = 10000;
		if(!"".equals(uidStr) && uidStr != null){
			uid = Integer.parseInt(uidStr);
		}
		//设置操作符
		String oper = "查询汽车信息";
		//获取当前时间(操作时间)
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String opertime = df.format(new Date());// new Date()为获取当前系统时间
		//设置日志状态为存在
        Integer status2 = 0;
        //设置该次操默认成功
		String success = "成功";
		
		//获取汽车查询条件信息
		//创建汽车实体类
		Car car = new Car();
		//汽车id
		String caridStr = req.getParameter("carid");
		Integer carid = 0;
		if(caridStr != null && !"".equals(caridStr)){
			carid = Integer.parseInt(caridStr);
		}
		
		String type = req.getParameter("type"); //类型
		String color = req.getParameter("color"); //颜色
		String priceStr = req.getParameter("price"); //价格
		
		Double price = 0.0;
		if(priceStr != null && !"".equals(priceStr)){
			price = Double.parseDouble(priceStr);
		}
		Double rentprice = 0.0;
		String rentpriceStr = req.getParameter("rentprice"); 
		if(rentpriceStr != null && !"".equals(rentpriceStr)){
			rentprice = Double.parseDouble(rentpriceStr);
		}
		String depositStr = req.getParameter("deposit");
		Double deposit = 0.0;
		if(depositStr != null && !"".equals(depositStr)){
			deposit = Double.parseDouble(depositStr);
		}
		
		String status = req.getParameter("status");
		
		car.setCarid(carid);
		car.setType(type);
		car.setColor(color);
		car.setPrice(price);
		car.setRentprice(rentprice);
		car.setDeposit(deposit);
		car.setStatus(status);
		
		int num = Integer.parseInt(req.getParameter("num"));
		int pageSize = Integer.parseInt(req.getParameter("pageSize"));
		
		CarPage cp = carServiceImpl.selectAllCarByCarInfoService(car , num , pageSize);
		req.setAttribute("cp", cp);
		req.setAttribute("oc", car);
		
		//添加日志信息
		int num2 = carOperServiceImpl.insertIntoSlfService(uid, oper, opertime, status2, success);
		if(num2 > 0){
			System.out.println(opertime);
			System.out.println("插入日志成功!");
		}
		
		return "carManager/viewCars";
	}
	
	/**
	 * 根据carid修改汽车信息
	 * @param carid
	 * @return
	 */
	@RequestMapping("upCar") 
	public String upDateCar(HttpServletRequest req){
		String caridStr = req.getParameter("carid");
		Integer carid = 0;
		if(caridStr != null && !"".equals(caridStr)){
			carid = Integer.parseInt(caridStr);
		}
		Car car = carServiceImpl.selectOneCarByCaridService(carid);
		req.setAttribute("car", car);
		return "carManager/updateCar";
	}
	
	/**
	 * 根据carid修改汽车信息
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("updateCar")
	public String updateCar6(Car car , MultipartFile file , HttpServletRequest req) throws IllegalStateException, IOException{
		
		System.out.println(car);
		
		//将附件储存到服务器硬盘
		//校验文件类型
		//获取文件名
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		String uname = UUID.randomUUID()+"";
		fileName = uname.replace("-", "") + fileName;
		//动态获取项目下路径
		String path=req.getServletContext().getRealPath("/Car-photo");
		System.out.println(path);
		
		car.setImg(fileName);
		int num = carServiceImpl.updateOneCarByCaridService(car);
		if(num > 0){
			//获取文件后缀名
			if(".jpg".equals(suffix) || ".png".equals(suffix) || ".gif".equals(suffix) || ".bmp".equals(suffix)){
				//写入文件
				file.transferTo(new File(path,fileName));
				car.setImg(fileName);
			}
			return "carManager/OK";
		}
		return "carManager/Failed";
	}
	
	/**
	 * 根据汽车ID删除汽车信息
	 * @param carid
	 * @param req
	 * @return
	 */
	@RequestMapping("delCar")
	public String deleteCarCon(Integer carid , HttpServletRequest req){
		//获取当前用户上传的文件名
		String carPath = (carServiceImpl.selectOneCarByCaridService(carid)).getImg();
		//操作数据库删除指定汽车
		int num = carServiceImpl.deleteOneCarByCaridService(carid);
		if(num > 0){
			//同时删除 本地文件
			//获取动态服务器图片路径
			String realPath = req.getServletContext().getRealPath("/Car-photo");
			//创建File对象
			File photo = new File(realPath + carPath);
			if(photo.isFile() && photo.exists()){
				//删除文件
				photo.delete();
			}
			return "carManager/OK";
		}
		return "carManager/Failed";
	}
	
}	
