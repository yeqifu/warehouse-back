package com.yeqifu.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeqifu.system.domain.Dept;

/**
* @Author: 落亦-
* @Date: 2020/2/4 10:32
*/
public interface DeptMapper extends BaseMapper<Dept> {
    /**
     * 查询最大排序码
     * @return      排序码
     */
    Integer queryDeptMaxOrderNum();

    /**
     * 根据ID查询其子部门的个数
     * @param id
     * @return
     */
    Integer queryDeptChildrenCountById(Integer id);
}