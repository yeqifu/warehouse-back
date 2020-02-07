package com.yeqifu.system.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 落亦-
 * @Date: 2020/2/6 21:11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserVo extends BaseVo {

    private String name;

    private String address;

    private String remark;

    private Integer deptid;

    private Integer available;

}
