package com.yeqifu.system.controller;

import com.yeqifu.system.common.ResultObj;
import com.yeqifu.system.domain.User;
import com.yeqifu.system.service.UserService;
import com.yeqifu.system.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
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
     * 删除用户
     * @param id    用户ID
     * @return      ResultObj
     */
    @RequestMapping("deleteUser")
    public ResultObj deleteUser(Integer id){
        try {
            userService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }


}
