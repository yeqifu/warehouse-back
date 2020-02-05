package com.yeqifu.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeqifu.system.domain.Menu;

/**
* @Author: 落亦-
* @Date: 2020/1/30 10:26
*/
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 查询菜单和权限最大排序码
     * @return
     */
    Integer queryMenuMaxOrderNum();

    /**
     * 根据ID查询当前菜单和权限的子菜单和权限的个数
     * @param id
     * @return
     */
    Integer queryMenuChildrenCountById(Integer id);
}