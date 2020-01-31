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

}
