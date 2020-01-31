package com.yeqifu.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeqifu.system.common.Constant;
import com.yeqifu.system.domain.Menu;
import com.yeqifu.system.mapper.MenuMapper;
import com.yeqifu.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

/**
* @Author: 落亦-
* @Date: 2020/1/30 10:26
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService{

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> queryAllMenuForList() {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("available", Constant.AVAILABLE_TRUE);
        queryWrapper.and(new Consumer<QueryWrapper<Menu>>() {
            @Override
            public void accept(QueryWrapper<Menu> menuQueryWrapper) {
                menuQueryWrapper.eq("type",Constant.MENU_TYPE_TOP)
                        .or().eq("type",Constant.MENU_TYPE_LEFT);
            }
        });
        queryWrapper.orderByAsc("ordernum");
        return this.menuMapper.selectList(queryWrapper);
    }

    @Override
    public List<Menu> queryMenuForListByUserId(Integer id) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("available", Constant.AVAILABLE_TRUE);
        queryWrapper.and(new Consumer<QueryWrapper<Menu>>() {
            @Override
            public void accept(QueryWrapper<Menu> menuQueryWrapper) {
                menuQueryWrapper.eq("type",Constant.MENU_TYPE_TOP)
                        .or().eq("type",Constant.MENU_TYPE_LEFT);
            }
        });
        queryWrapper.orderByAsc("ordernum");
        return this.menuMapper.selectList(queryWrapper);
    }
}
