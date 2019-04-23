package com.xyq.service;

import com.xyq.entity.Role;
import com.xyq.entity.RolePage;
import com.xyq.vo.PermissionTreeVO;

import java.util.List;

public interface RoleService {

    /**
     * 根据角色id删除角色信息
     * @param rid
     */
    void delRole(int rid);

    /**
     * 添加角色
     * @param role
     */
    void insRole(Role role);

    /**
     * 根据角色条件查询角色信息
     * @param role
     * @param pageNum
     * @return
     */
    RolePage selRole(Role role, int pageNum, int pageSize);

    /**
     * 修改角色信息
     * @param role
     */
    void upRole(Role role);

    /**
     * 查询角色
     * @param roleName
     * @return
     */
     Role selRole(String roleName);

    /**
     * 根据角色名称查询角色树
     * @param rname
     * @return
     */
    List<PermissionTreeVO> grantPermission(String rname);

    /**
     * 根据角色id删除该角色的所有权限
     * @param rid
     */
    void delPermissionByRId(int rid);

    /**
     * 根据角色id插入该角色的所有权限
     * @param split
     * @param rid
     */
    void insPermissionByRId(String[] split, int rid);

    /**
     * 根据角色id查询角色信息
     * @param rid
     * @return
     */
    Role selRoleByRId(Integer rid);
}
