package com.bjsxt.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.bjsxt.pojo.Student;
import com.bjsxt.pojo.Subject;
import com.bjsxt.pojo.Teacher;
import com.bjsxt.service.ScoreService;
import com.bjsxt.service.impl.ScoreServiceImpl;
import com.bjsxt.vo.PageVo;
import com.bjsxt.vo.ScoreVo;
import com.bjsxt.vo.StudentScoreVo;
import com.bjsxt.vo.TotalVo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 成绩管理
 * @author 997
 *
 */
public class ScoreServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 根据老师的id获取所带的课程
	 * @param tid
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void findSubjectByTid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//获取session中的信息
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("tea");
		//调用service层的方法
		ScoreService scoreService = new ScoreServiceImpl();
		List<Subject> subjectList = scoreService.findSubjectByTid(teacher.getTid());
		//响应请求结果
		req.setAttribute("subjectList", subjectList);
		req.getRequestDispatcher("/result/resultinput.jsp").forward(req, resp);
	}
	/**
	 * 获取选择tid老师所带的subid课程的学生
	 * @param subid
	 * @param tid
	 * @return
	 * @throws IOException 
	 */
	public void findStudentBySubid(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//获取请求数据
		String subidStr = req.getParameter("value");
		if(subidStr != null && !"".equals(subidStr)){
			int subid = Integer.valueOf(subidStr);
			
			//调用service层的方法
			ScoreService scoreService = new ScoreServiceImpl();
			//获取session中的数据
			HttpSession session = req.getSession();
			Teacher teacher = (Teacher) session.getAttribute("tea");
			List<Student> studentList = scoreService.findStudentBySubid(subid, teacher.getTid());
			//将studentList转为json
			Gson gson = new Gson();
			String studentListjson = gson.toJson(studentList);
			//响应请求结果
			//设置响应格式
			resp.setContentType("text/json");
			resp.getWriter().println(studentListjson);
		}
	}
	/**
	 * 更新学生成绩信息
	 * @param sid
	 * @param subid
	 * @return
	 * @throws IOException 
	 */
	public void updateScoreByid(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//获取请求信息
		int subid = 0;
		int sid = 0;
		int score = 0;
		String subjectId = req.getParameter("subjectId");
		if(subjectId != null && !"".equals(subjectId)){
			subid = Integer.valueOf(subjectId);
		}
		String studentId = req.getParameter("studentId");
		if(subjectId != null && !"".equals(studentId)){
			sid = Integer.valueOf(studentId);
		}
		String scoreStr = req.getParameter("score");
		if(scoreStr != null && !"".equals(scoreStr)){
			score = Integer.valueOf(scoreStr);
		}
		//调用service层的方法
		ScoreService scoreService = new ScoreServiceImpl();
		int num = scoreService.updateScoreByid(sid, subid, score);
		if(num != -1){
			//重定向到list界面
			resp.sendRedirect(req.getContextPath()+"/result/resultInquiry.jsp");
		}
		
	}
	/**
	 * 分页查询学生成绩
	 * @return
	 * @throws IOException 
	 */
	public void pageQuery(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//获取请求数据
		int pageSize = 0;
		int pageNum = 0;
		String pageSizeStr = req.getParameter("pageSize");
		if(pageSizeStr != null && !"".equals(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		String pageNumStr = req.getParameter("pageNum");
		if(pageNumStr != null && !"".equals(pageNumStr)){
			pageNum = Integer.valueOf(pageNumStr);
		}
		
		//获取session中的信息
		HttpSession session = req.getSession();
		int rid = (int) session.getAttribute("rid");
		Object obj = null;
		if(rid == 1){
			obj = session.getAttribute("stu");
		}else{
			obj = session.getAttribute("tea");
		}
		//调用service层的方法
		ScoreService scoreService = new ScoreServiceImpl();
		PageVo pageVo = scoreService.pageQuery(pageNum, pageSize, rid, obj);
		//转换为json
		Gson gson = new Gson();
		String sslistjson = gson.toJson(pageVo);
		//响应请求结果
		resp.setContentType("text/json");
		resp.getWriter().write(sslistjson);
	}
	/**
	 * 带条件的分页查询
	 * @return
	 * @throws IOException 
	 */
	public void pageQueryByArgs(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//获取请求结果
		int pageSize = 0;
		int pageNum = 0;
		int type = 0;
		
		String pageSizeStr = req.getParameter("pageSize");
		if(pageSizeStr != null && !"".equals(pageSizeStr)){
			pageSize = Integer.valueOf(pageSizeStr);
		}
		String pageNumStr = req.getParameter("pageNum");
		if(pageNumStr != null && !"".equals(pageNumStr)){
			pageNum = Integer.valueOf(pageNumStr);
		}
		String typeStr = req.getParameter("type");
		if(typeStr != null && !"".equals(typeStr)){
			type = Integer.valueOf(typeStr);
		}
		String cond = req.getParameter("cond");
		//获取session中的信息
		HttpSession session = req.getSession();
		int rid = (int) session.getAttribute("rid");
		Object obj = null;
		if(rid == 1){
			obj = session.getAttribute("stu");
		}else{
			obj = session.getAttribute("tea");
		}
		//调用service层的方法
		ScoreService scoreService = new ScoreServiceImpl();
		PageVo pageVo = scoreService.pageQueryByArgs(pageNum, pageSize, rid, obj, type, cond);
		//转换为json
		Gson gson = new Gson();
		String sslistjson = gson.toJson(pageVo);
		//响应请求结果
		resp.setContentType("text/json");
		resp.getWriter().write(sslistjson);
		
	}
	/**
	 * 班级成绩统计
	 * @param cid
	 * @return
	 * @throws IOException 
	 */
	public void findScoreByClasses(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//获取请求数据
		int cid = -1;
		String choose = req.getParameter("choose");
		if(choose != null && !"".equals(choose)){
			cid = Integer.valueOf(choose);
		}
		//调用service层的方法
		ScoreService scoreService = new ScoreServiceImpl();
		List<ScoreVo> svList = scoreService.getScoreByClasses(cid);
		//转换为json
		Gson gson = new Gson();
		String svListjson = gson.toJson(svList);
		//响应请求结果
		resp.setContentType("text/json");
		resp.getWriter().write(svListjson);
	}
	/**
	 * 
	 * @param gid
	 * @param subid
	 * @return
	 * @throws IOException 
	 */
	public void findScoreByGrade(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//获取请求数据
		int gid = -1;
		String gidStr = req.getParameter("gid");
		if(gidStr != null && !"".equals(gidStr)){
			gid = Integer.valueOf(gidStr);
		}
		//调用service的方法
		ScoreService scoreService = new ScoreServiceImpl();
		List<TotalVo> ttl = scoreService.findScoreByGrade(gid);
		//转换为json
		Gson gson = new Gson();
		String ttListjson = gson.toJson(ttl);
		//响应结果
		resp.getWriter().write(ttListjson);
	}
	
	/**
	 * 查询该年级开那些课
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	public void beforefindScoreByGrade(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//获取请求数据
		int gid = -1;
		String gidStr = req.getParameter("gid");
		if(gidStr != null && !"".equals(gidStr)){
			gid = Integer.valueOf(gidStr);
		}
		//调用service层的方法
		ScoreService scoreService = new ScoreServiceImpl();
		List<Subject> subList = scoreService.beforefindScoreByGrade(gid);
		//转换为json
		Gson gson = new Gson();
		String svListjson = gson.toJson(subList);
		//响应请求结果
		resp.setContentType("text/json");
		resp.getWriter().write(svListjson);
	}
	
	public void exportExcle(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//获取请求数据
		String parameter = req.getParameter("dyDate");
		Gson gson = new Gson();
		List<StudentScoreVo> ssList= gson.fromJson(parameter, new TypeToken<List<StudentScoreVo>>() {}.getType());

		// 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("成绩表");
        /**
         *  可以合并行和列
         */
        CellRangeAddress region = new CellRangeAddress(0, // first row
                0, // last row
                0, // first column
                6 // last column
        );
        sheet.addMergedRegion(region);
        
        /**
         * 
         * 创建 表的行  第一行 
         */
        HSSFRow hssfRow = sheet.createRow(0);
        /**
         * 创建单元格  第一个单元格
         */
        
        // 设置单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
    	cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
        HSSFCell headCell = hssfRow.createCell(0);
        /**
         * 添加内容
         */
        headCell.setCellValue("学生成绩列表");
        headCell.setCellStyle(cellStyle);
        // 添加表头行
        hssfRow = sheet.createRow(1);
        // 添加表头内容
        headCell = hssfRow.createCell(0);
        headCell.setCellValue("编号");
        headCell.setCellStyle(cellStyle);
        
        headCell = hssfRow.createCell(1);
        headCell.setCellValue("姓名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(2);
        headCell.setCellValue("年级");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(3);
        headCell.setCellValue("班级");
        headCell.setCellStyle(cellStyle);
        
        headCell = hssfRow.createCell(4);
        headCell.setCellValue("课程");
        headCell.setCellStyle(cellStyle);
        
        headCell = hssfRow.createCell(5);
        headCell.setCellValue("老师");
        headCell.setCellStyle(cellStyle);
        
        headCell = hssfRow.createCell(6);
        headCell.setCellValue("成绩");
        headCell.setCellStyle(cellStyle);
        

        // 添加数据内容
        for (int i = 0; i < ssList.size(); i++) {
            hssfRow = sheet.createRow((int) i + 2);
            StudentScoreVo studentScoreVo = ssList.get(i);

            // 创建单元格，并设置值
            HSSFCell cell = hssfRow.createCell(0);
            cell.setCellValue(studentScoreVo.getSid());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(1);
            cell.setCellValue(studentScoreVo.getSname());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(2);
            cell.setCellValue(studentScoreVo.getGrade());
            cell.setCellStyle(cellStyle);
            
            cell = hssfRow.createCell(3);
            cell.setCellValue(studentScoreVo.getCname());
            cell.setCellStyle(cellStyle);
            
            cell = hssfRow.createCell(4);
            cell.setCellValue(studentScoreVo.getSubname());
            cell.setCellStyle(cellStyle);
            
            cell = hssfRow.createCell(5);
            cell.setCellValue(studentScoreVo.getTname());
            cell.setCellStyle(cellStyle);
            
            cell = hssfRow.createCell(6);
            cell.setCellValue(studentScoreVo.getScore());
            cell.setCellStyle(cellStyle);
        }

        // 保存Excel文件
        try {
            OutputStream outputStream = new FileOutputStream("D:/score.xls");
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //响应结果
        resp.getWriter().println("1");
		
	}
	
	
}
