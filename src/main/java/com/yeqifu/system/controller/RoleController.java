package com.yeqifu.system.controller;

import com.yeqifu.system.common.Constant;
import com.yeqifu.system.common.DataGridView;
import com.yeqifu.system.common.ResultObj;
import com.yeqifu.system.domain.Role;
import com.yeqifu.system.service.RoleService;
import com.yeqifu.system.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author: 落亦-
 * @Date: 2020/2/6 10:33
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色
     * @param roleVo
     * @return          DataGridView
     */
    @RequestMapping("queryAllRole")
    public Object queryAllRole(RoleVo roleVo){
        return roleService.queryAllRole(roleVo);
    }

    /**
     * 加载所有可用的角色不分页
     * @param roleVo
     * @return
     */
    @RequestMapping("loadAllAvailableRoleNoPage")
    public Object loadAllAvailableRoleNoPage(RoleVo roleVo){
        roleVo.setAvailable(Constant.AVAILABLE_TRUE);
        return roleService.loadAllAvailableRoleNoPage(roleVo);
    }

    /**
     * 添加角色
     * @param role  角色实体类
     * @return      ResultObj
     */
    @RequestMapping("addRole")
    public ResultObj addRole(Role role){
        try {
            role.setCreatetime(new Date());
            roleService.saveRole(role);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改角色
     * @param role  角色ID
     * @return      ResultObj
     */
    @RequestMapping("updateRole")
    public ResultObj updateRole(Role role){
        try {
            roleService.updateRole(role);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除角色
     * @param id    角色ID
     * @return      ResultObj
     */
    @RequestMapping("deleteRole")
    public ResultObj deleteRole(Integer id){
        try {
            roleService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 根据角色ID查询该角色拥有的所有菜单
     * @param id    角色ID
     * @return      菜单ID集合
     */
    @RequestMapping("queryMenuIdsByRid")
    public Object queryMenuIdsByRid(Integer id){
        List<Integer> mids=roleService.queryMenuIdsByRid(id);
        return new DataGridView(mids);
    }

    /**
     * 保存角色和菜单权限之间的关系
     * @param rid   角色ID
     * @param mids  菜单和权限ID形式的数组
     * @return      ResultObj
     */
    @RequestMapping("saveRoleMenu")
    public ResultObj saveRoleMenu(Integer rid,Integer[] mids){
        try {
            roleService.saveRoleMenu(rid,mids);
            return ResultObj.DISPATCH_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DISPATCH_ERROR;
        }
    }


}
