package com.yeqifu.system.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: 落亦-
 * @Date: 2020/2/2 19:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NoticeVo extends BaseVo {

    /**
     * 公告标题
     */
    private String title;
    /**
     * 操作人
     */
    private String opername;
    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
