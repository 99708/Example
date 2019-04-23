package com.xyq.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyq.entity.CusPage;
import com.xyq.entity.Customer;
import com.xyq.service.CustomersService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
public class CustomersController {

	@Resource
	private CustomersService customersService;

	/**
	 * 校验用户
	 * @param idcard
	 * @return
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
		 * 跳转到更新用户信息页面
		 * @param idcard
		 * @param req
		 * @return
		 */
		@RequestMapping("upCusView")
		public String upCusView(String idcard,HttpServletRequest req){
			Customer cus = customersService.selOneCus(idcard);
			req.setAttribute("cus", cus);
			return "custManager/updateCustomers";
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
				return "custManager/findCustomers";
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
				return "custManager/findCustomers";
			}else{
				return "forward:/error.jsp";
			}
		}
		/**
		 * 单个客户信息查询
		 * @param idcard
		 * @param req
		 * @return
		 */
		@RequestMapping("selOneCus")
		public String selOneCus(String idcard,HttpServletRequest req){

			Customer cus = customersService.selOneCus(idcard);
			req.setAttribute("cus", cus);
			return "custManager/viewCustomers";
		}



	/**
	 * 分页查询客户信息
	 * @param cus
	 * @param pageNum
	 * @return
	 */
		@ResponseBody
		@RequestMapping("selCus")
		public CusPage selCus(Customer cus,int pageNum, int pageSize){
			CusPage cp = customersService.selCus(cus, pageNum, pageSize);
			return cp;
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
				return "custManager/findCustomers";
			}else{
				return "forward:/error.jsp";
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
	@RequestMapping("exportCustomerExcel")
	public void exportExcel(HttpServletRequest req, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {

		String customerList = req.getParameter("customerList");
		ObjectMapper mapper = new ObjectMapper();
		List<Customer> customers = mapper.readValue(customerList,new TypeReference<List<Customer>>() { });
		// 创建一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表
		HSSFSheet sheet = workbook.createSheet("客户信息记录表");
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
		headCell.setCellValue("客户信息记录表");
		headCell.setCellStyle(titleStyle);

		// 添加表头行并添加内容以及设置格式
		hssfRow = sheet.createRow(1);
		headCell = hssfRow.createCell(0);
		headCell.setCellValue("序号");
		headCell.setCellStyle(headStyle);

		headCell = hssfRow.createCell(1);
		headCell.setCellValue("身份证号码");
		headCell.setCellStyle(headStyle);

		headCell = hssfRow.createCell(2);
		headCell.setCellValue("姓名");
		headCell.setCellStyle(headStyle);

		headCell = hssfRow.createCell(3);
		headCell.setCellValue("电话号码");
		headCell.setCellStyle(headStyle);

		headCell = hssfRow.createCell(4);
		headCell.setCellValue("性别");
		headCell.setCellStyle(headStyle);

		headCell = hssfRow.createCell(5);
		headCell.setCellValue("职业");
		headCell.setCellStyle(headStyle);


		// 添加数据内容
		for (int i = 0; i < customers.size(); i++) {
			hssfRow = sheet.createRow((int) i + 2);
			Customer customer = customers.get(i);

			// 创建单元格，并设置值
			HSSFCell cell = hssfRow.createCell(0);
			cell.setCellValue(i+1);
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(1);
			cell.setCellValue(customer.getIdcard());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(2);
			cell.setCellValue(customer.getCname());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(3);
			cell.setCellValue(customer.getPhone());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(4);
			cell.setCellValue(customer.getSex());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(5);
			cell.setCellValue(customer.getJob());
			cell.setCellStyle(cellStyle);
		}

		//下载Excel
		String returnName = "客户信息记录表.xls";

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
