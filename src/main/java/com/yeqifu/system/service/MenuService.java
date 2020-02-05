package com.yeqifu.system.service;

import com.yeqifu.system.common.DataGridView;
import com.yeqifu.system.domain.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yeqifu.system.vo.MenuVo;

import java.util.List;

/**
* @Author: 落亦-
* @Date: 2020/1/30 10:26
*/
public interface MenuService extends IService<Menu>{


    /**
     * 全查询菜单
     * @return
     */
    List<Menu> queryAllMenuForList();

    /**
     * 根据用户ID查询菜单
     * @param id
     * @return
     */
    List<Menu> queryMenuForListByUserId(Integer id);

    /**
     * 查询所有菜单
     * @param menuVo
     * @return
     */
    DataGridView queryAllMenu(MenuVo menuVo);

    /**
     * 查询菜单和权限最大排序码
     * @return
     */
    Integer queryMenuMaxOrderNum();

    /**
     * 添加菜单或权限
     * @param menu
     * @return
     */
    Menu saveMenu(Menu menu);

    /**
     * 修改菜单和权限
     * @param menu
     * @return
     */
    Menu updateMenu(Menu menu);

    /**
     * 根据ID查询当前菜单和权限的子菜单和权限的个数
     * @param id
     * @return
     */
    Integer queryMenuChildrenCountById(Integer id);
}
