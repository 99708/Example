package com.xyq.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyq.entity.Car;
import com.xyq.entity.CarPage;
import com.xyq.entity.User;
import com.xyq.service.CarOperService;
import com.xyq.service.CarService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
public class CarController {
	
	//声明汽车Service属性
	@Resource
	private CarService carServiceImpl;
	@Resource
	private CarOperService carOperServiceImpl;
	
	/**
	 * 添加汽车信息的方法
	 * @param car
	 * @param file
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("insCar")
	public String insertCarNowMethod(Car car , MultipartFile file , HttpServletRequest req) throws IllegalStateException, IOException{

		User user = (User) req.getSession().getAttribute("user");
		//设置操作符
		String oper = "添加汽车信息";
		//获取当前时间(操作时间)
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String opertime = df.format(new Date());// new Date()为获取当前系统时间
		//将附件储存到服务器硬盘
		//获取文件名
		String fileName = file.getOriginalFilename();
		//获取文件后缀名
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		String uname = UUID.randomUUID()+"";
		//设置服务器中的名称
		fileName = uname.replace("-", "") + fileName;

		if(".jpg".equals(suffix) || ".png".equals(suffix) || ".gif".equals(suffix) || ".bmp".equals(suffix) || ".jpeg".equals(suffix)){
			//动态获取项目下路径
			String path=req.getServletContext().getRealPath("/Car-photo");
			//写入文件
			file.transferTo(new File(path,fileName));
			car.setImg(fileName);
			try {
				carServiceImpl.insertCarService(car);
				carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, 0, "添加汽车信息成功");
				return "carManager/findCar";
			} catch (Exception e) {//插入异常
				e.printStackTrace();
				carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, 0, "添加汽车信息失败"+e.getCause());
				return "carManager/failed";
			}
		}else{
            carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, 0, "添加汽车信息失败上传的图片格式不支持");
            return "carManager/imgFailed";
        }

	}

	/**
	 * 单个汽车信息查询
	 * @param carid
	 * @param req
	 * @return
	 */
	@RequestMapping("selOneCar")
	public String selOneCus(String carid,HttpServletRequest req){

		User user = (User) req.getSession().getAttribute("user");
		//设置操作符
		String oper = "查看汽车详情";
		//获取当前时间(操作时间)
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String opertime = df.format(new Date());// new Date()为获取当前系统时间

		try {//查询成功
			Car car = carServiceImpl.selectOneCarByCaridService(Integer.parseInt(carid));
			req.setAttribute("car", car);
			carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, 0, "查看汽车详情成功");
			return "carManager/viewCars";
		} catch (NumberFormatException e) {//查询失败
			e.printStackTrace();
			carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, 0, "查看汽车详情失败"+e.getCause());
			return "carManager/failed";
		}
	}

	/**
	 * 根据条件分页查询所有汽车
	 * @param car
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("selCar")
	public CarPage selCar(Car car, int pageNum, int pageSize, HttpServletRequest req){

		CarPage cp = new CarPage();

		User user = (User) req.getSession().getAttribute("user");
		//设置操作符
		String oper = "查询汽车信息";
		//获取当前时间(操作时间)
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String opertime = df.format(new Date());// new Date()为获取当前系统时间

		try {//查询成功
			cp = carServiceImpl.selectAllCarByCarInfoService(car, pageNum, pageSize);
			carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, 0, "查询汽车信息成功");
		} catch (Exception e) {//查询失败
			carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, 0, "查询汽车信息失败"+e.getCause());
			e.printStackTrace();
		}
		return cp;
	}
	
	/**
	 * 跳转到修改界面并携带数据
	 * @return
	 */
	@RequestMapping("upCarView")
	public String upDateCar(HttpServletRequest req){
		String carid = req.getParameter("carid");
		Car car = carServiceImpl.selectOneCarByCaridService(Integer.parseInt(carid));
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
	public String updateCar(Car car , MultipartFile file , HttpServletRequest req) throws IllegalStateException, IOException{

		User user = (User) req.getSession().getAttribute("user");
		//设置操作符
		String oper = "修改汽车信息";
		//获取当前时间(操作时间)
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String opertime = df.format(new Date());// new Date()为获取当前系统时间
		//将附件储存到服务器硬盘
       if(file.getSize() != 0){//上传文件不为空
           //获取文件名
           String fileName = file.getOriginalFilename();
           //获取文件后缀名
           String suffix = fileName.substring(fileName.lastIndexOf("."));
           String uname = UUID.randomUUID()+"";
           //设置服务器中的名称
           fileName = uname.replace("-", "") + fileName;

           if(".jpg".equals(suffix) || ".png".equals(suffix) || ".gif".equals(suffix) || ".bmp".equals(suffix) || ".jpeg".equals(suffix)){
               //动态获取项目下路径
               String path=req.getServletContext().getRealPath("/Car-photo");
               //写入文件
               file.transferTo(new File(path,fileName));
               car.setImg(fileName);
               try {
                   carServiceImpl.updateOneCarByCaridService(car);
                   carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, 0, "修改汽车信息成功");
                   return "carManager/findCar";
               } catch (Exception e) {//更新异常
                   e.printStackTrace();
                   carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, 0, "修改汽车信息失败"+e.getCause());
                   return "carManager/failed";
               }
           }else{
               carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, 0, "修改汽车信息失败上传的图片格式不支持");
               return "carManager/imgFailed";
           }
       }else{//图片没有被修改，不需要图片的保存
           try {
               carServiceImpl.updateOneCarByCaridService(car);
               carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, 0, "修改汽车信息成功");
               return "carManager/findCar";
           } catch (Exception e) {//更新异常
               e.printStackTrace();
               carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, 0, "修改汽车信息失败"+e.getCause());
               return "carManager/failed";
           }
       }

	}
	
	/**
	 * 根据汽车ID删除汽车信息
	 * @param carid
	 * @param req
	 * @return
	 */
	@RequestMapping("delCar")
	public String deleteCarCon(Integer carid , HttpServletRequest req){

        User user = (User) req.getSession().getAttribute("user");
        //设置操作符
        String oper = "修改汽车信息";
        //获取当前时间(操作时间)
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String opertime = df.format(new Date());// new Date()为获取当前系统时间

        try {
            //获取当前用户上传的文件名
            String carPath = (carServiceImpl.selectOneCarByCaridService(carid)).getImg();
            //操作数据库删除指定汽车
            int num = carServiceImpl.deleteOneCarByCaridService(carid);
            //同时删除 本地文件
            //获取动态服务器图片路径
            String realPath = req.getServletContext().getRealPath("/Car-photo");
            //创建File对象
            File photo = new File(realPath + carPath);
            if(photo.isFile() && photo.exists()){
                //删除文件
                photo.delete();
            }
            carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, 0, "删除汽车信息成功");
            return "carManager/findCar";
        } catch (Exception e) {
            e.printStackTrace();
            carOperServiceImpl.insertIntoSlfService(user.getUid(), oper, opertime, 0, "删除汽车信息失败"+e.getCause());
            return "carManager/failed";
        }

	}

	/**
	 * 维护主键
	 * @param carid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("selCarByCarid")
	public String selCarByIdcard(String carid) {
		Car car = carServiceImpl.selectOneCarByCaridService(Integer.parseInt(carid));
		if(car!=null){
			return "false";
		}else{
			return "true";
		}
	}

	/**
	 * POI导出Excel
	 * @param req
	 * @param response
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping("exportCarExcel")
	public void exportExcel(HttpServletRequest req, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {

		String cs = req.getParameter("cs");
		ObjectMapper mapper = new ObjectMapper();
		List<Car> cars = mapper.readValue(cs,new TypeReference<List<Car>>() { });
		// 创建一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表
		HSSFSheet sheet = workbook.createSheet("汽车信息记录表");
		//设置列宽
		for (int rowNum = 0; rowNum < 6; rowNum++) {
			if(rowNum == 1){
				sheet.setColumnWidth(rowNum, (100*60));
			}else if(rowNum == 3){
				sheet.setColumnWidth(rowNum, (80*60));
			}else{
				sheet.setColumnWidth(rowNum, (50*60));
			}
		}

		//创建表格样式对象和字体对象
		HSSFCellStyle titleStyle = workbook.createCellStyle(); //标题样式对象
		HSSFFont titleFont = workbook.createFont();			   //标题字体对象
		HSSFCellStyle headStyle = workbook.createCellStyle(); //表头样式对象
		HSSFFont headFont = workbook.createFont();			   //表头字体对象
		HSSFCellStyle cellStyle = workbook.createCellStyle(); //表格内容样式对象
		HSSFFont cellFont = workbook.createFont();			   //表格字体对象

		//设置表格样式对象
		//标题样式
		//字体设置
		//设置字体大小
		titleFont.setFontHeightInPoints((short)24);
		//字体加粗
		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		//设置字体名字
		titleFont.setFontName("华文楷体");
		//在样式用应用设置的字体;
		titleStyle.setFont(titleFont);
		//格式设置
		//水平居中
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//垂直居中
		titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		//表头样式
		//字体设置
		//设置字体大小
		headFont.setFontHeightInPoints((short)14);
		//字体加粗
		headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		//设置字体名字
		headFont.setFontName("华文楷体");
		//在样式用应用设置的字体;
		headStyle.setFont(headFont);
		//边框设置
		//设置底边框;
		headStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		//设置底边框颜色;
		headStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		//设置左边框;
		headStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		//设置左边框颜色;
		headStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		//设置右边框;
		headStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		//设置右边框颜色;
		headStyle.setRightBorderColor(HSSFColor.BLACK.index);
		//设置顶边框;
		headStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		//设置顶边框颜色;
		headStyle.setTopBorderColor(HSSFColor.BLACK.index);
		//格式设置
		//水平居中
		headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//垂直居中
		headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//表格内容样式
		//边框设置
		//设置底边框;
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		//设置底边框颜色;
		cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		//设置左边框;
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		//设置左边框颜色;
		cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		//设置右边框;
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		//设置右边框颜色;
		cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
		//设置顶边框;
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		//设置顶边框颜色;
		cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
		//格式设置
		//水平居中
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//垂直居中
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);


		//合并标题行
		CellRangeAddress region = new CellRangeAddress(0, // first row
				0, // last row
				0, // first column
				5 // last column
		);
		sheet.addMergedRegion(region);


		//创建标题并添加内容以及设置格式
		HSSFRow hssfRow = sheet.createRow(0);
		HSSFCell headCell = hssfRow.createCell(0);
		headCell.setCellValue("汽车信息记录表");
		headCell.setCellStyle(titleStyle);

		// 添加表头行并添加内容以及设置格式
		hssfRow = sheet.createRow(1);
		headCell = hssfRow.createCell(0);
		headCell.setCellValue("序号");
		headCell.setCellStyle(headStyle);

		headCell = hssfRow.createCell(1);
		headCell.setCellValue("汽车编号");
		headCell.setCellStyle(headStyle);

		headCell = hssfRow.createCell(2);
		headCell.setCellValue("汽车型号");
		headCell.setCellStyle(headStyle);

		headCell = hssfRow.createCell(3);
		headCell.setCellValue("汽车价格");
		headCell.setCellStyle(headStyle);

		headCell = hssfRow.createCell(4);
		headCell.setCellValue("汽车租金");
		headCell.setCellStyle(headStyle);

		headCell = hssfRow.createCell(5);
		headCell.setCellValue("租用情况");
		headCell.setCellStyle(headStyle);


		// 添加数据内容
		for (int i = 0; i < cars.size(); i++) {
			hssfRow = sheet.createRow((int) i + 2);
			Car car = cars.get(i);

			// 创建单元格，并设置值
			HSSFCell cell = hssfRow.createCell(0);
			cell.setCellValue(i+1);
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(1);
			cell.setCellValue(car.getCarid());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(2);
			cell.setCellValue(car.getType());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(3);
			cell.setCellValue(car.getPrice());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(4);
			cell.setCellValue(car.getRentprice());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(5);
			cell.setCellValue(car.getStatus());
			cell.setCellStyle(cellStyle);
		}

		//下载Excel
		String returnName = "汽车信息记录表.xls";

		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//解决文件名中文乱码问题
		returnName  = new String(returnName.getBytes("utf-8") , "iso8859-1");
		response.setHeader("Content-Disposition", "attachment;filename=" + returnName);

		ServletOutputStream sos = response.getOutputStream();
		workbook.write(sos);
		sos.flush();
		sos.close();
	}

}	
