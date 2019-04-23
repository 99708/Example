package com.xyq.ego.sso.service;

import com.xyq.ego.rpc.pojo.TbUser;
import com.xyq.entity.EgoResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户信息处理
 */
public interface SsoUserService {
    /**
     * 对用户的唯一字段进行验证
     * @return
     */
    public EgoResult loadTbUserByCond(String cond, Integer type);

    /**
     * 用户注册
     * @param tbUser
     * @return
     */
    public EgoResult saveUserService(TbUser tbUser);

    /**
     * 用户登录
     * @param uname
     * @return
     */
    public EgoResult selectUserByUserName (String uname, String pwd, HttpServletRequest req, HttpServletResponse resp);

    /**
     * 根据token校验用户
     * @param token
     * @return
     */
    public EgoResult loadUserStatusByToken(String token);

    /**
     * 安全退出
     * @param token
     * @return
     */
    public EgoResult deleteUserStatusByToken(String token);
}
