package com.yeqifu.system.service;

import com.yeqifu.system.common.DataGridView;
import com.yeqifu.system.domain.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yeqifu.system.vo.NoticeVo;

/**
* @Author: 落亦-
* @Date: 2020/2/2 19:50
*/
public interface NoticeService extends IService<Notice>{

    /**
     * 查询所有登陆日志
     * @param noticeVo
     * @return  DataGridView
     */
    DataGridView queryAllNotice(NoticeVo noticeVo);
}
