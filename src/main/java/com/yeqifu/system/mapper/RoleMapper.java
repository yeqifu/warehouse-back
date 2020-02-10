package com.yeqifu.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeqifu.system.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
* @Author: 落亦-
* @Date: 2020/2/6 10:23
*/
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据角色ID删除角色和菜单之间的关系
     * @param id
     */
    void deleteRoleMenuByRid(Serializable id);

    /**
     * 根据菜单ID删除角色和菜单之间的关系
     * @param id
     */
    void deleteRoleMenuByMid(Serializable id);

    /**
     * 根据角色ID删除角色和用户之间的关系
     * @param id
     */
    void deleteRoleUserByRid(Serializable id);

    /**
     * 根据用户ID删除角色和用户之间的关系
     * @param id
     */
    void deleteRoleUserByUid(Serializable id);

    /**
     * 根据角色ID查询出该角色拥有的菜单ID和权限ID的集合
     * @param id
     * @return
     */
    List<Integer> queryMenuIdsByRid(Integer id);

    /**
     * 保存角色和菜单之间的关系
     * @param rid
     * @param mid
     */
    void insertRoleMenu(@Param("rid") Integer rid,@Param("mid") Integer mid);

    /**
     * 通过用户ID查询该用户所拥有的角色ID
     * @param userId    用户ID
     * @return          角色ID的集合
     */
    List<Integer> queryRoleIdsByUserId(Integer userId);

    List<Integer> queryMenuIdsByRids(@Param("roleIds") List<Integer> roleIds);
}