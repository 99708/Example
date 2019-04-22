package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.LoginPage;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.User;
import com.bjsxt.pojo.UserPage;
import com.bjsxt.vo.RoleVo;



/**
 * 管理员业务逻辑接口
 * @author Qiao
 *
 */
public interface UserService {
	//校验用户
	User selUid(int uid);
	//根据uid删除用户密码
	int delUser(int uid);
	//根据uid和pwd修改用户密码
	int upPwd(int uid,int oldPwd,int newUserPwd);
	//添加用户
	int insUser(User u);
	//根据用户条件查询用户信息
	UserPage selUser(User u,int pageNum);
	//根据uid查用户
	User selOneUser(int uid);
	//修改用户信息
	int upUser(User u);
	/**
	 * 用户登录时校验账号密码
	 * @param uid
	 * @param pwd
	 * @return
	 */
	public User selUserByUidPwd(int uid,String pwd);
	
	/**
	 * 用户登录时插入登录记录
	 * @param uid
	 * @param ip
	 * @return
	 */
	public int insertUserLoginInfo(int uid,String ip);
	
	/**
	 * 用户登录信息分页查询
	 * @param uname
	 * @param ip
	 * @param time
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public LoginPage selLoginInfo(String uname,String ip,String time,int pageNum,int pageSize);
	
	/**
	 * RBAC权限控制
	 * @param rid
	 * @param pid
	 * @return
	 */
	public List<Menu> selRBAC(int rid, int pid);
	
	/**
	 * 角色管理
	 * @param uname
	 * @return
	 */
	public List<RoleVo> selRole(String uname);

}