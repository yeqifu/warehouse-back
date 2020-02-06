package com.yeqifu.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yeqifu.system.common.DataGridView;
import com.yeqifu.system.domain.Role;
import com.yeqifu.system.vo.RoleVo;

import java.util.List;

/**
* @Author: 落亦-
* @Date: 2020/2/6 10:23
*/
public interface RoleService extends IService<Role>{

    /**
     * 查询所有角色
     * @param roleVo
     * @return
     */
    DataGridView queryAllRole(RoleVo roleVo);

    /**
     * 保存角色
     * @param role
     * @return
     */
    Role saveRole(Role role);

    /**
     * 修改角色
     * @param role
     * @return
     */
    Role updateRole(Role role);

    /**
     * 根据角色ID查询该角色拥有的所有菜单的集合
     * @param id
     * @return
     */
    List<Integer> queryMenuIdsByRid(Integer id);

    /**
     * 给角色分配菜单和权限
     * @param rid   角色
     * @param mids  菜单和权限ID
     */
     void saveRoleMenu(Integer rid, Integer[] mids);
}
