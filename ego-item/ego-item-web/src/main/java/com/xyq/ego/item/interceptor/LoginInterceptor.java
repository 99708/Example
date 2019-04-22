package com.xyq.ego.item.interceptor;

import com.xyq.ego.rpc.pojo.TbUser;
import com.xyq.entity.EgoResult;
import com.xyq.utils.CookieUtils;
import com.xyq.utils.JsonUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;

/***
 * 自定义拦截器类
 * @author Administrator
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    //获得用户登录状态的请求地址
    private String SSO_USER_TOKEN = "http://localhost:8083/user/token/";
    private String SSO_USER_LOGIN = "http://localhost:8083/login";

    @Resource
    private RestTemplate restTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //验证用户的登录状态
        //获得token
        String token = CookieUtils.getCookieValue(request, "sso_token");
        if (!StringUtils.isEmpty(token)) {
            //查询redis数据库，获得用户登录状态
			/*ResponseEntity<EgoResult> entity
				= restTemplate.getForEntity(SSO_USER_TOKEN+token, EgoResult.class);*/
            EgoResult result = restTemplate.getForObject(SSO_USER_TOKEN + token, EgoResult.class);
            if (result != null && result.getStatus() == 200) {
                //正确获得用户登录状态
                //TbUser user=(TbUser) result.getData();
                LinkedHashMap map = (LinkedHashMap) result.getData();
                System.out.println("===========" + map);
                //将map集合转化为json字符串
                String jsonStr = JsonUtils.objectToJson(map);
                System.out.println("==========" + jsonStr);
                //将json字符串转化为User对象
                TbUser user = JsonUtils.jsonToPojo(jsonStr, TbUser.class);
                //将当前登录用户保存到request作用。
                request.setAttribute("tbUser", user);

                return true; //拦截放行
            }
        }
        //跳转到登录页面
        response.sendRedirect(SSO_USER_LOGIN + "?redirectUrl=" + request.getRequestURL());
        return false;
    }
}

