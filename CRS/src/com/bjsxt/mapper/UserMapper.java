package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Login;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.User;
import com.bjsxt.vo.RoleVo;



public interface UserMapper {
	//校验用户
	User selUid(int uid);
	//根据uid删除用户
	int delUser(int uid);
	//根据uid和pwd修改用户密码
	int upPwd(int uid,int oldPwd,int newUserPwd);
	//修改用户信息
	int upUser(User u);
	//根据uid查询用户
	User selOneUser(int uid);
	//查询总行数
	int selCount(User u);
	//添加用户
	int insUser(User u);
	//根据用户条件查询用户信息
	List<User> selUser(@Param("u")User u,@Param("pageStart")int pageStart);
	/**
	 * 用户登录时校验账号密码
	 * @param uid
	 * @param pwd
	 * @return
	 */
	@Select("select * from user where uid=#{0} and pwd=#{1}")
	public User selUserByUidPwd(int uid,String pwd);
	
	/**
	 * 用户登录时插入登录记录
	 * @param uid
	 * @param ip
	 * @return
	 */
	@Insert("insert into log values(default,#{0},#{1},now())")
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
	public List<Login> selLoginInfo(String uname,String ip,String time,int pageNum,int pageSize);
	
	/**
	 * 用户登录信息总记录数
	 * @param uname
	 * @param ip
	 * @param time
	 * @return
	 */
	public int selLoginCounts(String uname,String ip,String time);
	
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
	@Select("SELECT * FROM USER u NATURAL JOIN role r NATURAL JOIN role_menu rm NATURAL JOIN menu m where u.uname=#{0}")
	public List<RoleVo> selRole(String uname);

}