package com.yeqifu.system.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 落亦-
 * @Date: 2020/2/5 14:15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MenuVo extends BaseVo {
    Integer available;
    private String title;

    /**
     * 0  不要权限
     */
    private Integer hasPermission;
}
