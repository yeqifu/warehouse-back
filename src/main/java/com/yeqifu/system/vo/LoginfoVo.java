package com.yeqifu.system.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: 落亦-
 * @Date: 2020/2/1 15:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginfoVo extends BaseVo{

    private String loginname;
    private String loginip;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
