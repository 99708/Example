package com.xyq.controller;

import com.xyq.entity.Role;
import com.xyq.entity.RolePage;
import com.xyq.service.RoleService;
import com.xyq.vo.PermissionTreeVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RoleController {

    @Resource
    private RoleService roleServiceImpl;

    /**
     * 添加角色界面跳转
     * @return
     */
    @RequestMapping("insRoleView")
    public String insRoleView(String roleName, HttpServletRequest req){
        req.setAttribute("roleName", roleName);
        return "roleManager/roleAdd";
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequestMapping("insRole")
    public String insUser(Role role){
        try {
            roleServiceImpl.insRole(role);
            return "roleManager/roleList";
        } catch (Exception e) {
            e.printStackTrace();
            return "roleManager/fail";
        }

    }

    /**
     * ajax角色查找
     * @param roleName
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("selRoleView")
    public String selRoleView(String roleName,HttpServletRequest request){
        Role role = roleServiceImpl.selRole(roleName);
        if(null != role){
            return "true";
        }else{
            return "false";
        }
    }

    /**
     * 非ajax角色查找
     * @param roleName
     * @param request
     * @return
     */
    @RequestMapping("selRoleByRoleName")
    public String selRoleByRoleName(String roleName,HttpServletRequest request){
        try {
            Role role = roleServiceImpl.selRole(roleName);
            request.setAttribute("role", role);
            return "roleManager/roleList";
        } catch (Exception e) {
            e.printStackTrace();
            return "roleManager/fail";
        }
    }

    /**
     * 根据条件查询角色信息
     * @param role
     * @param pageNum
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping("selRole")
    public RolePage selRole(Role role, int pageNum, int pageSize, HttpServletRequest req){
        if(null == role) {
            role = (Role)req.getAttribute("role");
        }
        RolePage rolePage = roleServiceImpl.selRole(role,pageNum, pageSize);
        return rolePage;
    }

    /**
     * 根据角色id删除角色信息
     * @param rid
     * @return
     */
    @RequestMapping("delRole")
    public String delRole(int rid, HttpServletRequest req){
        try {
            roleServiceImpl.delRole(rid);
            return "roleManager/roleList";
        } catch (Exception e) {
            e.printStackTrace();
            return "roleManager/fail";
        }
    }

    /**
     * 根据角色名称修改角色信息视图跳转
     * @param req
     * @return
     */
    @RequestMapping("upRoleView")
    public String upRoleView(HttpServletRequest req){
        String rname = req.getParameter("rname");
        Role role = roleServiceImpl.selRole(rname);
        req.setAttribute("role", role);
        return "roleManager/roleUpdate";
    }

    /**
     * 根据角色名称修改角色信息
     * @param role
     * @return
     */
    @RequestMapping("upRole")
    public String upRole(Role role){
        try {
            roleServiceImpl.upRole(role);
            return "roleManager/roleList";
        } catch (Exception e) {
            e.printStackTrace();
            return "roleManager/fail";
        }
    }

    /**
     * 根据角色名称修改角色信息页面跳转
     * @param rname
     * @param req
     * @return
     */
    @RequestMapping("grantPermissionView")
    public String grantPermissionView(String rname, HttpServletRequest req){
        try {
            Role role = roleServiceImpl.selRole(rname);
            req.getSession().setAttribute("role", role);
            return "roleManager/grantPermission";
        } catch (Exception e) {
            e.printStackTrace();
            return "roleManager/fail";
        }
    }

    /**
     * ajax查询用户权限
     * @param rname
     * @return
     */
    @ResponseBody
    @RequestMapping("grantPermission")
    public List<PermissionTreeVO> grantPermission(String rname){
        List<PermissionTreeVO> ptvo = roleServiceImpl.grantPermission(rname);
        return ptvo;
    }

    /**
     *
     * @param moduleIds
     * @param rid
     * @return
     */
    @RequestMapping("upPermission")
    public String upPermission(String moduleIds, int rid){
        //获取本次分配的所有权限
        String[] split = moduleIds.split(",");
        try {
            //删除该角色的所有权限
            roleServiceImpl.delPermissionByRId(rid);
            //添加这次提交所有权限
            roleServiceImpl.insPermissionByRId(split, rid);
            return "roleManager/roleList";
        } catch (Exception e) {
            e.printStackTrace();
            return "roleManager/fail";
        }
    }

}
