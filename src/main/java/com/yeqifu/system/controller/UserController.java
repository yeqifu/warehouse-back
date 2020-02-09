package com.yeqifu.system.controller;

import com.yeqifu.system.common.Constant;
import com.yeqifu.system.common.DataGridView;
import com.yeqifu.system.common.MD5Utils;
import com.yeqifu.system.common.ResultObj;
import com.yeqifu.system.domain.User;
import com.yeqifu.system.service.UserService;
import com.yeqifu.system.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 落亦-
 * @Date: 2020/2/6 21:06
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @param userVo
     * @return          DataGridView
     */
    @RequestMapping("queryAllUser")
    public Object queryAllUser(UserVo userVo){
        return userService.queryAllUser(userVo);
    }

    /**
     * 添加用户
     * @param user  用户实体类
     * @return      ResultObj
     */
    @RequestMapping("addUser")
    public ResultObj addUser(User user){
        try {
            userService.saveUser(user);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 根据部门ID查询出该部门所有员工
     * @param deptId
     * @return
     */
    @GetMapping("loadUsersByDeptId")
    public DataGridView loadUsersByDeptId(Integer deptId){
        DataGridView dataGridView = userService.loadUsersByDeptId(deptId);
        return dataGridView;
    }

    /**
     * 查询用户最大排序码
     * @return      排序码
     */
    @GetMapping("queryUserMaxOrderNum")
    public Object queryUserMaxOrderNum(){
        Integer maxValue = userService.queryUserMaxOrderNum();
        return new DataGridView(maxValue+1);
    }

    /**
     * 修改用户
     * @param user  用户ID
     * @return      ResultObj
     */
    @RequestMapping("updateUser")
    public ResultObj updateUser(User user){
        try {
            userService.updateUser(user);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 通过用户ID查询出该用户
     * @param id    用户ID
     * @return      user
     */
    @RequestMapping("loadUserById")
    public User loadUserById(Integer id){
        User user = userService.getById(id);
        return user;
    }

    /**
     * 重置用户密码
     * @param id    用户ID
     * @return      ResultObj
     */
    @RequestMapping("resetUserPwd")
    public ResultObj resetUserPwd(Integer id){
        try {
            User user = new User();
            user.setId(id);
            user.setSalt(MD5Utils.createUUID());
            user.setPwd(MD5Utils.md5(Constant.DEFAULT_PASSWORD,user.getSalt(),2));
            userService.updateUser(user);
            return ResultObj.RESET_PWD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.RESET_PWD_ERROR;
        }
    }

    /**
     * 删除用户
     * @param id    用户ID
     * @return      ResultObj
     */
    @RequestMapping("deleteUser")
    public ResultObj deleteUser(Integer id){
        try {
            //去数据库中查询该用户是否是其他用户的直属领导
            Boolean isMgr = userService.queryOtherUserMgr(id);
            if (isMgr){
                return ResultObj.DELETE_ERROR_NEWS;
            }else {
                userService.removeById(id);
                return ResultObj.DELETE_SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 保存用户和角色之间的关系
     * @param uid       用户ID
     * @param rids      多个角色形成的数组
     * @return
     */
    @RequestMapping("saveUserRole")
    public ResultObj saveUserRole(Integer uid,Integer[] rids){
        try {
            userService.saveUserRole(uid,rids);
            return ResultObj.DISPATCH_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DISPATCH_ERROR;
        }
    }

}
