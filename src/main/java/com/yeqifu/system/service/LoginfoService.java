package com.yeqifu.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yeqifu.system.common.DataGridView;
import com.yeqifu.system.domain.Loginfo;
import com.yeqifu.system.vo.LoginfoVo;

/**
* @Author: 落亦-
* @Date: 2020/2/1 15:46
*/
public interface LoginfoService extends IService<Loginfo>{

    /**
     * 查询所有日志
     * @param loginfoVo 表单查询日志的条件
     * @return  DataGridView
     */
    DataGridView queryAllLoginfo(LoginfoVo loginfoVo);

}
