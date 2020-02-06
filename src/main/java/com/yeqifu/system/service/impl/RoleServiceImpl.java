package com.yeqifu.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeqifu.system.common.DataGridView;
import com.yeqifu.system.domain.Role;
import com.yeqifu.system.mapper.RoleMapper;
import com.yeqifu.system.service.RoleService;
import com.yeqifu.system.vo.RoleVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
* @Author: 落亦-
* @Date: 2020/2/6 10:23
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService{

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询所有角色
     * @param roleVo
     * @return
     */
    @Override
    public DataGridView queryAllRole(RoleVo roleVo) {
        IPage<Role> page = new Page<>(roleVo.getPage(),roleVo.getLimit());
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(roleVo.getAvailable()!=null,"available",roleVo.getAvailable());
        queryWrapper.like(StringUtils.isNotBlank(roleVo.getName()),"name",roleVo.getName());
        queryWrapper.like(StringUtils.isNotBlank(roleVo.getRemark()),"remark",roleVo.getRemark());
        queryWrapper.ge(roleVo.getStartTime()!=null,"createtime",roleVo.getStartTime());
        queryWrapper.le(roleVo.getEndTime()!=null,"createtime",roleVo.getEndTime());
        roleMapper.selectPage(page,queryWrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    /**
     * 保存角色
     * @param role
     * @return
     */
    @Override
    public Role saveRole(Role role) {
        roleMapper.insert(role);
        return role;
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @Override
    public Role updateRole(Role role) {
        roleMapper.updateById(role);
        return role;
    }

    /**
     * 根据角色ID查询该角色拥有的菜单ID和权限ID的集合
     * @param id
     * @return
     */
    @Override
    public List<Integer> queryMenuIdsByRid(Integer id) {
        return roleMapper.queryMenuIdsByRid(id);
    }

    /**
     * 保存角色和菜单之间的关系
     * @param rid   角色
     * @param mids  菜单和权限ID
     */
    @Override
    public void saveRoleMenu(Integer rid, Integer[] mids) {
        //根据rid删除sys_role_menu里面的数据
        roleMapper.deleteRoleMenuByRid(rid);
        if (null!=mids&&mids.length>0){
            for (Integer mid : mids) {
                roleMapper.insertRoleMenu(rid,mid);
            }
        }

    }

    /**
     * 删除角色
     * @param id    角色ID
     * @return
     */
    @Override
    public boolean removeById(Serializable id) {
        //根据角色ID删除角色和菜单之间的关系
        roleMapper.deleteRoleMenuByRid(id);
        //根据角色ID删除角色和用户之间的关系
        roleMapper.deleteRoleUserByRid(id);
        return super.removeById(id);
    }
}
