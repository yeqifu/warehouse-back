package com.yeqifu.system.controller;

import com.yeqifu.system.common.Constant;
import com.yeqifu.system.common.DataGridView;
import com.yeqifu.system.common.ResultObj;
import com.yeqifu.system.domain.Menu;
import com.yeqifu.system.service.MenuService;
import com.yeqifu.system.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 落亦-
 * @Date: 2020/2/5 14:11
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询所有菜单和权限
     * @param menuVo
     * @return
     */
    @RequestMapping("loadAllMenu")
    public Object loadAllMenu(MenuVo menuVo){
        return menuService.queryAllMenu(menuVo);
    }

    /**
     * 只查询菜单
     * @param menuVo
     * @return
     */
    @RequestMapping("loadMenu")
    public Object loadMenu(MenuVo menuVo){
        List<Menu> menus = menuService.queryAllMenuForList();
        return new DataGridView(Long.valueOf(menus.size()),menus);

    }

    /**
     * 查询菜单和权限最大的排序码
     * @return
     */
    @GetMapping("queryMenuMaxOrderNum")
    public Object queryMenuMaxOrderNum(){
        Integer maxValue = menuService.queryMenuMaxOrderNum();
        return new DataGridView(maxValue+1);
    }

    /**
     * 添加菜单和权限
     * @param menu
     * @return
     */
    @PostMapping("addMenu")
    public ResultObj addMenu(Menu menu){
        try {
            if (menu.getType().equals("topmenu")){
                menu.setPid(0);
            }
            menu.setSpread(Constant.SPREAD_FALSE);
            menu.setAvailable(Constant.AVAILABLE_TRUE);
            menuService.saveMenu(menu);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改菜单和权限
     * @param menu
     * @return
     */
    @PostMapping("updateMenu")
    public ResultObj updateMenu(Menu menu){
        try {
            menuService.updateMenu(menu);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
    @GetMapping("getMenuById")
    public Object getMenuById(Integer id){
        return new DataGridView(this.menuService.getById(id));
    }

    /**
     * 根据ID查询当前菜单和权限的子菜单和权限个数
     * @param id
     * @return
     */
    @GetMapping("getMenuChildrenCountById")
    public Object getMenuChildrenCountById(Integer id){
        Integer count = menuService.queryMenuChildrenCountById(id);
        return new DataGridView(count);
    }

    /**
     * 删除菜单或权限
     * @param id    菜单或权限ID
     * @return
     */
    @PostMapping("deleteMenu")
    public ResultObj deleteMenu(Integer id){
        try {
            menuService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }


}
