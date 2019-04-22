package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjsxt.mapper.UserMapper;
import com.bjsxt.pojo.Login;
import com.bjsxt.pojo.LoginPage;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.User;
import com.bjsxt.pojo.UserPage;
import com.bjsxt.service.UserService;
import com.bjsxt.vo.RoleVo;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;
	/**
	 * 添加用户
	 */
	@Override
	public int insUser(User u) {
		
		return userMapper.insUser(u);
	}
	/**
	 * 查询用户信息
	 */
	@Override
	public UserPage selUser(User u ,int pageNum1) {
		UserPage up =new UserPage();
		//总行数
		int count = userMapper.selCount(u);
		int pageSize = 2;
		int pageNum = pageNum1;
		int pageStart = pageNum*pageSize-pageSize;
		int pages = (int)Math.ceil(count*1.0/pageSize);
		List<User> lu = userMapper.selUser(u,pageStart);
	
		up.setCount(count);
		up.setPageNum(pageNum);
		up.setPages(pages);
		up.setPageStart(pageStart);
		up.setLu(lu);
		up.setPageSize(pageSize);
		return up;
	}

	@Override
	public User selUserByUidPwd(int uid, String pwd) {
		
		return userMapper.selUserByUidPwd(uid, pwd);
	}
	/**
	 * 根据uid查询用户信息
	 */
	@Override
	public User selOneUser(int uid) {
		
		return userMapper.selOneUser(uid);
	}
	/**
	 * 修改用户信息
	 */
	@Override
	public int upUser(User u) {
		int i = userMapper.upUser(u);
		return i;
	}
	/**
	 * 根据uid和pwd修改用户密码
	 */
	@Override
	public int upPwd(int uid, int oldPwd, int newUserPwd) {
		
		return userMapper.upPwd(uid, oldPwd, newUserPwd);
	}
	/**
	 * 根据uid删除用户密码
	 */
	@Override
	public int delUser(int uid) {
		
		return userMapper.delUser(uid);
	}

	/**
	 * 用户登录时插入登录记录
	 */
	@Override
	public int insertUserLoginInfo(int uid, String ip) {
		return userMapper.insertUserLoginInfo(uid, ip);
	}

	/**
	 * 校验用户
	 */
	@Override
	public User selUid(int uid) {
		
		return userMapper.selUid(uid);
	}
	
	/**
	 * 用户登录信息分页查询
	 */
	@Override
	public LoginPage selLoginInfo(String uname, String ip, String time, int pageNum, int pageSize) {
		int pageStart=pageNum*pageSize-pageSize;
		LoginPage page = new LoginPage();
		page.setPageStart(pageStart);
		page.setPageSize(pageSize);
		List<Login> loginList = userMapper.selLoginInfo(uname, ip, time, pageStart, pageSize);
		int count = userMapper.selLoginCounts(uname, ip, time);
		int pages=(int) Math.ceil(count*1.0/pageSize);
		page.setCount(count);
		page.setLoginList(loginList);
		page.setPages(pages);
		page.setPageNum(pageNum);
		return page;
	}
	
	/**
	 * RBAC权限控制
	 */
	@Override
	public List<Menu> selRBAC(int rid, int pid) {
		List<Menu> mList = userMapper.selRBAC(rid, pid);
		for(Menu m : mList) {
			List<Menu> m2 = userMapper.selRBAC(rid, m.getMid());
			m.setNextMenu(m2);
		}
		return mList;
	}
	
	@Override
	public List<RoleVo> selRole(String uname) {
		return userMapper.selRole(uname);
	}

}
