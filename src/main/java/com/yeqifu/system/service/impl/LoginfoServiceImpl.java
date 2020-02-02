package com.yeqifu.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeqifu.system.common.DataGridView;
import com.yeqifu.system.domain.Loginfo;
import com.yeqifu.system.mapper.LoginfoMapper;
import com.yeqifu.system.service.LoginfoService;
import com.yeqifu.system.vo.LoginfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* @Author: 落亦-
* @Date: 2020/2/1 15:46
*/
@Service
public class LoginfoServiceImpl extends ServiceImpl<LoginfoMapper, Loginfo> implements LoginfoService{

    @Autowired
    private LoginfoMapper loginfoMapper;

    @Override
    public DataGridView queryAllLoginfo(LoginfoVo loginfoVo) {

        IPage<Loginfo> page = new Page<>(loginfoVo.getPage(),loginfoVo.getLimit());
        QueryWrapper<Loginfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNoneBlank(loginfoVo.getLoginname()),"loginname",loginfoVo.getLoginname());
        queryWrapper.like(StringUtils.isNoneBlank(loginfoVo.getLoginip()),"loginip",loginfoVo.getLoginip());
        queryWrapper.ge(loginfoVo.getStartTime()!=null,"logintime",loginfoVo.getStartTime());
        queryWrapper.le(loginfoVo.getEndTime()!=null,"logintime",loginfoVo.getEndTime());
        queryWrapper.orderByDesc("logintime");
        loginfoMapper.selectPage(page,queryWrapper);

        return new DataGridView(page.getTotal(),page.getRecords());
    }
}
