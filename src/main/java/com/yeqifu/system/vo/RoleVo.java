package com.yeqifu.system.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: 落亦-
 * @Date: 2020/2/6 10:24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleVo extends BaseVo {

    private Integer userId;

    private String name;

    private String remark;

    private Integer available;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;


}
