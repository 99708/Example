package com.xyq.mapper;

import com.xyq.entity.Login;
import com.xyq.entity.Menu;
import com.xyq.entity.Role;
import com.xyq.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;




public interface UserMapper {
	//校验用户
	User selUid(int uid);
	//根据uid删除用户
	int delUser(int uid);
	//根据uid和pwd修改用户密码
	int upPwd(int uid, int oldPwd, int newUserPwd);
	//修改用户信息
	int upUser(User u);
	//根据uid查询用户
	User selOneUser(int uid);
	//查询总行数
	int selCount(@Param("user") User user, @Param("role") Role role);
	//添加用户
	int insUser(User u);
	//根据用户条件查询用户信息
	List<User> selUser(@Param("user") User user, @Param("role") Role role,@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
	/**
	 * 用户登录时校验账号密码
	 * @param uid
	 * @param pwd
	 * @return
	 */
	@Select("select * from user where uid=#{0} and pwd=#{1}")
	public User selUserByUidPwd(int uid, String pwd);
	
	/**
	 * 用户登录时插入登录记录
	 * @param uid
	 * @param ip
	 * @return
	 */
	@Insert("insert into log values(default,#{0},#{1},now())")
	public int insertUserLoginInfo(int uid, String ip);

	/**
	 * 用户登录信息分页查
	 * @param user
	 * @param login
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Login> selLoginInfo(@Param("user") User user, @Param("login") Login login, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

	/**
	 * 用户登录信息总记录数
	 * @param user
	 * @param login
	 * @return
	 */
	public int selLoginCounts(@Param("user") User user, @Param("login") Login login);
	
	/**
	 * RBAC权限控制
	 * @param rid
	 * @param pid
	 * @return
	 */
	public List<Menu> selRBAC(int rid, int pid);

	/**
	 * 查询角色
	 * @param roleName
	 * @return
	 */
	@Select("SELECT * FROM role where rname = #{roleName}")
	public Role selRole(@Param("roleName") String roleName);


}
