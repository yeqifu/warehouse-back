package com.yeqifu.system.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 落亦-
 * @Date: 2020/2/4 10:33
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DeptVo extends BaseVo {

    private String title;
    private String remark;
    private String address;
}
