package com.yeqifu.system.common;

/**
 * @Author: 落亦-
 * @Date: 2020/1/31 19:49
 */
public class Constant {

    /**
     * 用户类型    0：超级管理员      1：普通用户
     */
    public static final Integer USER_TYPE_SUPER=0;
    public static final Integer USER_TYPE_NORMAL=1;

    /**
     * 是否可用     0：不可用       1：可用
     */
    public static final Integer AVAILABLE_TRUE=1;
    public static final Integer AVAILABLE_FALSE=0;

    /**
     * 菜单类型     topmenu:顶部菜单    leftmenu:左边菜单    permission:增、删、改、差权限
     */
    public static final String MENU_TYPE_TOP="topmenu";
    public static final String MENU_TYPE_LEFT="leftmenu";
    public static final String MENU_TYPE_PERMISSION="permission";

    /**
     * 是否展开     0：不展开       1：展开
     */
    public static final Integer SPREAD_FALSE=0;
    public static final Integer SPREAD_TRUE=1;

    /**
     * 是否登录
     */
    public static final String IS_LOGIN="已登录";
    public static final String UN_LOGIN="未登录";

    /**
     * 是否删除成功
     */
    public static final String DELETE_ERROR ="删除失败！";
    public static final String DELETE_SUCCESS ="删除成功！";

    /**
     * 返回响应码    CODE_ERROR:-1  响应失败     CODE_SUCCESS:200    响应成功
     */
    public static final Integer CODE_ERROR = -1;
    public static final Integer CODE_SUCCESS = 200;

    /**
     * 批量删除成功
     */
    public static final String BATCHDELETE_SUCCESS = "批量删除成功！";
    public static final String BATCHDELETE_ERROR = "批量删除失败！";
    public static final String BATCHDELETE_ERROR_NEWS = "传入ID错误！";

    /**
     * 添加失败
     */
    public static final String ADD_SUCCESS = "添加成功";
    public static final String ADD_ERROR = "添加失败";

    /**
     * 修改
     */
    public static final String UPDATE_SUCCESS = "修改成功";
    public static final String UPDATE_ERROR = "修改失败";

    /**
     * 分配权限
     */
    public static final String DISPATCH_SUCCESS = "分配成功";
    public static final String DISPATCH_ERROR = "分配失败";

    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD="123456";

    /**
     * 默认头像地址
     */
    public static final String DEFAULT_IMAGE = "";
}
