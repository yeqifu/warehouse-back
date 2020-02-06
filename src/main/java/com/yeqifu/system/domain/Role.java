package com.yeqifu.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
* @Author: 落亦-
* @Date: 2020/2/6 10:23
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_role")
public class Role implements Serializable {
    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 是否可用
     */
    @TableField(value = "available")
    private Integer available;

    /**
     * 创建时间
     */
    @TableField(value = "createtime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_REMARK = "remark";

    public static final String COL_AVAILABLE = "available";

    public static final String COL_CREATETIME = "createtime";
}