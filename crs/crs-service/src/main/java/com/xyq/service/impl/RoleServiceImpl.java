package com.xyq.service.impl;

import com.xyq.entity.Menu;
import com.xyq.entity.Role;
import com.xyq.entity.RolePage;
import com.xyq.mapper.RoleMapper;
import com.xyq.service.RoleService;
import com.xyq.vo.PermissionTreeVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public void delRole(int rid) {
        //删除角色
        roleMapper.delRole(rid);
        //删除权限
        roleMapper.delPermissionByRId(rid);
    }

    @Override
    public void insRole(Role role) {
        roleMapper.insRole(role);
    }

    @Override
    public RolePage selRole(Role role, int pageNum, int pageSize) {
        //将查询页码转换为起始查询行号
        int pageStart = pageNum*pageSize-pageSize;
        //获取总的数据量
        int count = roleMapper.selRoleCount(role);
        //获取总的分页数量
        int pages = (int) Math.ceil(count*1.0/pageSize);
        //获取分页数据
        List<Role> rs = roleMapper.selRoles(role , pageStart , pageSize);

        //创建Page对象封装分页查询相关的所有数据，便于响应
        RolePage rp = new RolePage();
        rp.setCount(count);
        rp.setRs(rs);
        rp.setPageNum(pageNum);
        rp.setPages(pages);
        rp.setPageSize(pageSize);
        return rp;
    }

    @Override
    public void upRole(Role role) {
        roleMapper.upRole(role);
    }

    @Override
    public Role selRole(String roleName) {
        Role role = roleMapper.selRole(roleName);
        return role;
    }

    @Override
    public List<PermissionTreeVO> grantPermission(String rname) {
        List<PermissionTreeVO> ptvos = new ArrayList<PermissionTreeVO>();
        //查询角色信息
        Role role = roleMapper.selRole(rname);
        //查询所有菜单
        List<Menu> menus = roleMapper.selMenuAll();
        //查询该角色拥有的菜单
        List<Menu> roleMenus = roleMapper.selROleMenu(role.getRid());
        //给权限树赋值
        for(Menu m:menus ){
            PermissionTreeVO ptvo = new PermissionTreeVO();
            ptvo.setId(m.getMid());
            ptvo.setpId(m.getPid());
            ptvo.setName(m.getMname());
            if(roleMenus.contains(m)){
                ptvo.setChecked(true);
            }else {
                ptvo.setChecked(false);
            }
            ptvos.add(ptvo);
        }
        return ptvos;
    }

    @Override
    public void delPermissionByRId(int rid) {
        roleMapper.delPermissionByRId(rid);
    }

    @Override
    public void insPermissionByRId(String[] split, int rid) {
        roleMapper.insPermissionByRId(split, rid);
    }

    @Override
    public Role selRoleByRId(Integer rid) {
        return roleMapper.selRoleByRId(rid);
    }
}
