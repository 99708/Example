package com.xyq.ego.sso.controller;

import com.xyq.ego.rpc.pojo.TbUser;
import com.xyq.ego.sso.service.SsoUserService;
import com.xyq.entity.EgoResult;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SsoUserController {
    //注入service层对象
    @Resource
    private SsoUserService ssoUserServiceImpl;

    /**
     * 用户的唯一字段进行验证
     * @param param
     * @param type
     * @param callback
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/check/{param}/{type}", method = RequestMethod.GET)
    public MappingJacksonValue userCheck (@PathVariable String param, @PathVariable Integer type, @RequestParam(required = false) String callback){
        EgoResult egoResult = ssoUserServiceImpl.loadTbUserByCond(param, type);
        MappingJacksonValue value = new MappingJacksonValue(egoResult);
        //处理jsonp请求
        if(!StringUtils.isEmpty(callback)){
            value.setJsonpFunction(callback);
        }
        return value;
    }

    /**
     * 用户注册
     * @param tbUser
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public EgoResult userRegister(TbUser tbUser){
        return ssoUserServiceImpl.saveUserService(tbUser);
    }

    /**
     *
     * @param token
     * @param callback
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/token/{token}", method = RequestMethod.GET)
    public MappingJacksonValue userToken(@PathVariable String token, @RequestParam(required = false) String callback){

        EgoResult egoResult = ssoUserServiceImpl.loadUserStatusByToken(token);
        MappingJacksonValue value = new MappingJacksonValue(egoResult);
        if(!StringUtils.isEmpty(callback)){
            value.setJsonpFunction(callback);
        }
        return value;
    }

    /**
     * 安全退出
     * @param token
     * @param callback
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/logout/{token}", method = RequestMethod.GET)
    public MappingJacksonValue userLogout(@PathVariable String token, @RequestParam(required = false) String callback){
        EgoResult egoResult = ssoUserServiceImpl.deleteUserStatusByToken(token);
        MappingJacksonValue value = new MappingJacksonValue(egoResult);
        if(!StringUtils.isEmpty(callback)){
            value.setJsonpFunction(callback);
        }
        return value;
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public EgoResult userLogin(String username, String password, HttpServletResponse resp, HttpServletRequest req){
        return ssoUserServiceImpl.selectUserByUserName(username, password, req, resp);
    }

}
