package com.xyq.ego.rpc.service;

import com.xyq.ego.rpc.pojo.TbUser;
import com.xyq.entity.EgoResult;

/**
 * 用户信息处理
 */
public interface TbUserService {
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
    public TbUser selectUserByUserName (String uname);
}
