package com.xyq.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyq.entity.*;
import com.xyq.service.RoleService;
import com.xyq.service.UserService;
import com.xyq.vo.UserLoginVO;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@Controller
public class UserController {
	
	@Resource
	private UserService userServiceImpl;

	@Resource
	private RoleService roleServiceImpl;
	/**
	 * 校验添加用户是否重复
	 */
	@ResponseBody
	@RequestMapping("selUid")
	public String selUserUid(int uid){
		User u = userServiceImpl.selUid(uid);
		if(u!=null){
			return "false";
		}else{
			return "true";
		}
		
	}
	/**
	 * 根据uid删除用户
	 * @param uid
	 * @return
	 */
	@RequestMapping("delUser")
	public String delUser(int uid){
        try {
            userServiceImpl.delUser(uid);
            return "userManager/findUser";
        } catch (Exception e) {
            e.printStackTrace();
            return "userManager/failed";
        }
	}
	/**
	 * 修改密码
	 * @param uid
	 * @param oldPwd
	 * @param newUserPwd
	 * @return
	 */
	@RequestMapping("upPwd")
	public String upPwd(int uid,int oldPwd,int newUserPwd){
		System.out.println(uid+"***"+oldPwd+"**"+newUserPwd);
		int i = userServiceImpl.upPwd(uid, oldPwd, newUserPwd);
		if(i>0){
			return "forward:/ok.jsp";
		}else{
			return "forward:/error.jsp";
		}
	}
	/**
	 * 跳转到修改密码页面
	 * @param pwd
	 * @param uid
	 * @param req
	 * @return
	 */
	@RequestMapping("upUserPwd")
	public String upUserPwd(String pwd,int uid,HttpServletRequest req){
		System.out.println(pwd);
		System.out.println(uid);
		req.setAttribute("uid", uid);
		req.setAttribute("pwd", pwd);
		return "userManager/changeUserPwd";
	}

    /**
     * 跳转到修改用户页面
     * @param uid
     * @param req
     * @return
     */
    @RequestMapping("updateUserView")
    public String updateUserView(int uid,HttpServletRequest req){
        User u = userServiceImpl.selOneUser(uid);
        req.setAttribute("u", u);
        return "userManager/updateUser";
    }

	/**
	 * 修改用户信息
	 * @param u
	 * @return
	 */
	@RequestMapping("updateUser")
	public String updateUser(User u){
        try {
            userServiceImpl.upUser(u);
            return "userManager/findUser";
        } catch (Exception e) {
            e.printStackTrace();
            return "userManager/failed";
        }
	}
	/**
	 * 根据uid查询用户
	 * @param uid
	 * @param req
	 * @return
	 */
	@RequestMapping("selUserById")
	public String upUser(int uid,HttpServletRequest req){
		User u = userServiceImpl.selOneUser(uid);
		req.setAttribute("u", u);
		return "userManager/showUser";
	}

    /**
     * 根据条件查询用户信息
     * @param user
     * @param role
     * @param pageNum
     * @param pageSize
     * @return
     */
	@ResponseBody
	@RequestMapping("selUser")
	public UserPage selUser(User user, Role role, int pageNum, int pageSize){
		UserPage userPage = userServiceImpl.selUser(user, role, pageNum, pageSize);
		return userPage;
	}
	/**
	 * 添加用户
	 * @param u
	 * @return
	 */
	@RequestMapping("insUser")
	public String insUser(User u){
        try {
            userServiceImpl.insUser(u);
            return "userManager/findUser";
        } catch (Exception e) {
            e.printStackTrace();
            return "userManager/failed";
        }
	}
	@RequestMapping("jsp/{file}/{uri}")
	public String  getJsp(@PathVariable("file")String file,@PathVariable("uri")String uri){
		return file+"/"+uri;
	}
	
	/**
	 * 用户登录
	 * @param uid
	 * @param pwd
	 * @param code
	 * @param request
	 * @return
	 */
	@RequestMapping("login")
	public String login(int uid,String pwd,String code,HttpServletRequest request){
		HttpSession session = request.getSession();
		String rand = (String) session.getAttribute("rand");
		if(rand.equalsIgnoreCase(code)){
			User user = userServiceImpl.selUserByUidPwd(uid, pwd);	
			if(user==null){
				session.setAttribute("userError", "账号或密码错误");
				session.setAttribute("codeError", "");
				return "redirect:/login.jsp";
			}else{
				String ip = request.getRemoteAddr();
				userServiceImpl.insertUserLoginInfo(uid, ip);
				//根据角色id查到角色信息
				Role role = roleServiceImpl.selRoleByRId(user.getRid());
				user.setRole(role);
				//将用户信息记录到session中
				session.setAttribute("user", user);
				session.setAttribute("codeError", "");
				return "forward:/selRBAC";
			}
		}else{
			session.setAttribute("codeError", "验证码错误");
			return "redirect:/login.jsp";
		}		
	}

	/**
	 * 查询用户登录信息
	 * @param user
	 * @param login
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("selLoginInfo")
	public LoginPage selLoginInfo(User user, Login login, int pageNum, int pageSize, HttpServletRequest request){
		LoginPage loginPage = userServiceImpl.selLoginInfo(user, login, pageNum, pageSize);
		return loginPage;
	}
	
	/**
	 * RBAC
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("selRBAC")
	public String selRBAC(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<Menu> mList = userServiceImpl.selRBAC(user.getRid(), 0);
		session.setAttribute("mList", mList);
		return "redirect:/index.jsp";
	}
	
	/**
	 * 退出登录
	 * @param req
	 * @return
	 */
	@RequestMapping("exitLogin")
	public String exitLogin(HttpServletRequest req){
		//清除登录信息
		req.getSession().invalidate();
		return "redirect:/login.jsp";
	}

    /**
     * POI导出登录信息Excel
     * @param req
     * @param response
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    @RequestMapping("exportLoginExcel")
    public void exportExcel(HttpServletRequest req, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {

        String userLogin = req.getParameter("login");
        ObjectMapper mapper = new ObjectMapper();
        List<UserLoginVO> userLoginVos = mapper.readValue(userLogin,new TypeReference<List<UserLoginVO>>() { });
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("登录信息记录表");
        //设置列宽
        for (int rowNum = 0; rowNum < 4; rowNum++) {
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
                3 // last column
        );
        sheet.addMergedRegion(region);


        //创建标题并添加内容以及设置格式
        HSSFRow hssfRow = sheet.createRow(0);
        HSSFCell headCell = hssfRow.createCell(0);
        headCell.setCellValue("登录信息记录表");
        headCell.setCellStyle(titleStyle);

        // 添加表头行并添加内容以及设置格式
        hssfRow = sheet.createRow(1);
        headCell = hssfRow.createCell(0);
        headCell.setCellValue("序号");
        headCell.setCellStyle(headStyle);

        headCell = hssfRow.createCell(1);
        headCell.setCellValue("用户名");
        headCell.setCellStyle(headStyle);

        headCell = hssfRow.createCell(2);
        headCell.setCellValue("IP地址");
        headCell.setCellStyle(headStyle);

        headCell = hssfRow.createCell(3);
        headCell.setCellValue("登录时间");
        headCell.setCellStyle(headStyle);

        // 添加数据内容
        for (int i = 0; i < userLoginVos.size(); i++) {
            hssfRow = sheet.createRow((int) i + 2);
            UserLoginVO userLoginVO = userLoginVos.get(i);

            // 创建单元格，并设置值
            HSSFCell cell = hssfRow.createCell(0);
            cell.setCellValue(i+1);
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(1);
            cell.setCellValue(userLoginVO.getUser().getUname());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(2);
            cell.setCellValue(userLoginVO.getIp());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(3);
            cell.setCellValue(userLoginVO.getTime().substring(0,10));
            cell.setCellStyle(cellStyle);

        }

        //下载Excel
        String returnName = "登录信息记录表.xls";

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
