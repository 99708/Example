package com.xyq.mapper;

import com.xyq.entity.Menu;
import com.xyq.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    /**
     * 根据角色id删除角色信息
     * @param rid
     */
    void delRole(@Param("rid") int rid);

    /**
     * 添加角色
     * @param role
     */
    void insRole(@Param("role") Role role);

    /**
     * 根据角色条件查询角色信息
     * @param role
     * @param pageNum
     * @return
     */
    List<Role> selRoles(@Param("role") Role role, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    /**
     * 修改角色信息
     * @param role
     */
    void upRole( Role role);

    /**
     * 查询角色
     * @param roleName
     * @return
     */
    Role selRole(@Param("roleName") String roleName);

    /**
     * 根据条件统计角色总数量
     * @param role
     * @return
     */
    Integer selRoleCount(Role role);

    /**
     * 查询所有权限信息
     * @return
     */
    List<Menu> selMenuAll();

    /**
     * 根据角色id查询该角色拥有的菜单
     * @param rid
     * @return
     */
    List<Menu> selROleMenu(int rid);

    /**
     * 根据角色id删除该角色的所有权限
     * @param rid
     */
    void delPermissionByRId(@Param("rid") int rid);

    /**
     * 根据角色id插入该角色的所有权限
     * @param split
     * @param rid
     */
    void insPermissionByRId(@Param("array") String[] split, @Param("rid") int rid);

    /**
     * 根据角色id查询角色信息
     * @param rid
     * @return
     */
    Role selRoleByRId(@Param("rid") Integer rid);
}
