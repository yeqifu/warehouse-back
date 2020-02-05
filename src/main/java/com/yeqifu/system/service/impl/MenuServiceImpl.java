package com.yeqifu.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeqifu.system.common.Constant;
import com.yeqifu.system.common.DataGridView;
import com.yeqifu.system.domain.Menu;
import com.yeqifu.system.mapper.MenuMapper;
import com.yeqifu.system.service.MenuService;
import com.yeqifu.system.vo.MenuVo;
import org.apache.commons.lang3.StringUtils;
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

    /**
     * 查询所有菜单和权限
     * @param menuVo
     * @return
     */
    @Override
    public DataGridView queryAllMenu(MenuVo menuVo) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(menuVo.getAvailable()!=null,"available",menuVo.getAvailable());
        queryWrapper.like(StringUtils.isNotBlank(menuVo.getTitle()),"title",menuVo.getTitle());
        queryWrapper.orderByAsc("ordernum");
        List<Menu> menus = menuMapper.selectList(queryWrapper);
        return new DataGridView(Long.valueOf(menus.size()),menus);
    }

    /**
     * 查询菜单和权限最大排序码
     * @return
     */
    @Override
    public Integer queryMenuMaxOrderNum() {
        Integer max = menuMapper.queryMenuMaxOrderNum();
        return max;
    }

    /**
     * 添加菜单或权限
     * @param menu
     * @return
     */
    @Override
    public Menu saveMenu(Menu menu) {
        menuMapper.insert(menu);
        return menu;
    }

    /**
     * 修改菜单
     * @param menu
     * @return
     */
    @Override
    public Menu updateMenu(Menu menu) {
        menuMapper.updateById(menu);
        return menu;
    }

    /**
     * 根据ID查询当前菜单和权限的子菜单和权限的个数
     * @param id
     * @return
     */
    @Override
    public Integer queryMenuChildrenCountById(Integer id) {
        return menuMapper.queryMenuChildrenCountById(id);
    }


}
