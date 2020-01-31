package com.yeqifu.system.service;

import com.yeqifu.system.domain.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
