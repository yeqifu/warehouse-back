package com.yeqifu.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @Author: 落亦-
* @Date: 2020/1/30 16:39
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user")
public class User implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "loginname")
    private String loginname;

    @TableField(value = "pwd")
    private String pwd;

    @TableField(value = "address")
    private String address;

    @TableField(value = "sex")
    private Integer sex;

    @TableField(value = "remark")
    private String remark;

    @TableField(value = "deptid")
    private Integer deptid;

    @TableField(value = "hiredate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date hiredate;

    /**
     * 上级领导id
     */
    @TableField(value = "mgr")
    private Integer mgr;

    /**
     * 是否可用，0不可用，1可用
     */
    @TableField(value = "available")
    private Integer available;

    /**
     * 排序码
     */
    @TableField(value = "ordernum")
    private Integer ordernum;

    /**
     * 用户类型[0超级管理员，1管理员，2普通用户]
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 用户头像地址
     */
    @TableField(value = "imgpath")
    private String imgpath;

    /**
     * 盐
     */
    @TableField(value = "salt")
    private String salt;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_LOGINNAME = "loginname";

    public static final String COL_PWD = "pwd";

    public static final String COL_ADDRESS = "address";

    public static final String COL_SEX = "sex";

    public static final String COL_REMARK = "remark";

    public static final String COL_DEPTID = "deptid";

    public static final String COL_HIREDATE = "hiredate";

    public static final String COL_MGR = "mgr";

    public static final String COL_AVAILABLE = "available";

    public static final String COL_ORDERNUM = "ordernum";

    public static final String COL_TYPE = "type";

    public static final String COL_IMGPATH = "imgpath";

    public static final String COL_SALT = "salt";
}