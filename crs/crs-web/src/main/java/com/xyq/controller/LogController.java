package com.xyq.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyq.entity.SlfLog;
import com.xyq.entity.SlfPage;
import com.xyq.service.CarOperService;
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

/**
 * 日志管理
 */
@Controller
public class LogController {

    //声明汽车操作Service属性
    @Resource
    private CarOperService carOperServiceImpl;

    /**
     * 日志信息的分页查询
     * @param slfLog
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("selSlflog")
    public SlfPage selSlflog(SlfLog slfLog, Integer pageNum , Integer pageSize ){

        SlfPage sp = carOperServiceImpl.selectAllSLFByOUOService(slfLog, pageNum, pageSize);
        return sp;
    }

    /**
     * POI导出Excel
     * @param req
     * @param response
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping("exportSlfExcel")
    public void exportExcel(HttpServletRequest req, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {

        String slf = req.getParameter("slf");
        ObjectMapper mapper = new ObjectMapper();
        List<SlfLog> slfs = mapper.readValue(slf,new TypeReference<List<SlfLog>>() { });
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("日志信息记录表");
        //设置列宽
        for (int rowNum = 0; rowNum < 5; rowNum++) {
            if(rowNum == 0 || rowNum == 1){
                sheet.setColumnWidth(rowNum, (50*60));
            }else{
                sheet.setColumnWidth(rowNum, (100*60));
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
                4 // last column
        );
        sheet.addMergedRegion(region);


        //创建标题并添加内容以及设置格式
        HSSFRow hssfRow = sheet.createRow(0);
        HSSFCell headCell = hssfRow.createCell(0);
        headCell.setCellValue("日志信息记录表");
        headCell.setCellStyle(titleStyle);

        // 添加表头行并添加内容以及设置格式
        hssfRow = sheet.createRow(1);
        headCell = hssfRow.createCell(0);
        headCell.setCellValue("序号");
        headCell.setCellStyle(headStyle);

        headCell = hssfRow.createCell(1);
        headCell.setCellValue("用户ID");
        headCell.setCellStyle(headStyle);

        headCell = hssfRow.createCell(2);
        headCell.setCellValue("日志内容");
        headCell.setCellStyle(headStyle);

        headCell = hssfRow.createCell(3);
        headCell.setCellValue("事件时间");
        headCell.setCellStyle(headStyle);

        headCell = hssfRow.createCell(4);
        headCell.setCellValue("事件结果");
        headCell.setCellStyle(headStyle);

        // 添加数据内容
        for (int i = 0; i < slfs.size(); i++) {
            hssfRow = sheet.createRow((int) i + 2);
            SlfLog slfLog = slfs.get(i);

            // 创建单元格，并设置值
            HSSFCell cell = hssfRow.createCell(0);
            cell.setCellValue(i+1);
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(1);
            cell.setCellValue(slfLog.getUid());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(2);
            cell.setCellValue(slfLog.getOper());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(3);
            cell.setCellValue(slfLog.getOpertime().substring(0,10));
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(4);
            cell.setCellValue(slfLog.getSuccess());
            cell.setCellStyle(cellStyle);

        }

        //下载Excel
        String returnName = "日志信息记录表.xls";

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
