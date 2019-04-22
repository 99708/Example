package com.bjsxt.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.LoginPage;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.User;
import com.bjsxt.pojo.UserPage;
import com.bjsxt.service.UserService;
import com.bjsxt.vo.RoleVo;

@Controller
public class UserController {
	
	@Resource
	private UserService userServiceImpl;
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
		int i=userServiceImpl.delUser(uid);
		if(i>0){
			return "forward:/ok.jsp";
		}else{
			return "forward:/error.jsp";
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
	 * 修改用户信息
	 * @param u
	 * @return
	 */
	@RequestMapping("updateUser")
	public String updateUser(User u){
		System.out.println(u);
		int i = userServiceImpl.upUser(u);
		if(i>0){
			return "forward:/ok.jsp";
		}else{
			return "forward:/error.jsp";
		}
	}
	/**
	 * 根据uid查询用户
	 * @param uid
	 * @param req
	 * @return
	 */
	@RequestMapping("upUser")
	public String upUser(int uid,HttpServletRequest req){
		User u = userServiceImpl.selOneUser(uid);
		req.setAttribute("u", u);
		return "userManager/updateUser";
	}
	/**
	 * 根据条件查询用户信息
	 * @param u
	 * @return
	 */
	@RequestMapping("selUser")
	public String selUser(User u,int pageNum,HttpServletRequest req){
		req.setAttribute("u", u);
		UserPage userPage = userServiceImpl.selUser(u,pageNum);
		System.out.println(userPage.getLu());
		req.setAttribute("userPage", userPage);
		return "userManager/viewUser";
	}
	/**
	 * 添加用户
	 * @param u
	 * @return
	 */
	@RequestMapping("insUser")
	public String insUser(User u){
		int i = userServiceImpl.insUser(u);
		if(i>0){
			return "forward:/ok.jsp";
		}else{
			return "forward:/error.jsp";
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
				request.setAttribute("userError", "账号或密码错误");
				return "forward:/login.jsp";
			}else{
				String ip = request.getRemoteAddr();
				userServiceImpl.insertUserLoginInfo(uid, ip);
				session.setAttribute("user", user);
				return "forward:/selRBAC";
			}
		}else{
			request.setAttribute("codeError", "验证码错误");
			return "forward:/login.jsp";
		}		
	}
	
	/**
	 * 查询用户登录信息
	 * @param uname
	 * @param ip
	 * @param time
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("selLoginInfo")
	public LoginPage selLoginInfo(String uname,String ip,String time,int pageNum,int pageSize,HttpServletRequest request){
		LoginPage loginPage = userServiceImpl.selLoginInfo(uname, ip, time, pageNum, pageSize);
		System.out.println(loginPage);
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
	
	@RequestMapping("selRole")
	public String selRole(String uname,HttpServletRequest request){
		List<RoleVo> roleList = userServiceImpl.selRole(uname);
		request.setAttribute("roleList", roleList);
		return "systemManager/updateRole";
	}
}
