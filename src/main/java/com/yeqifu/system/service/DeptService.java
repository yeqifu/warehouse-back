package com.yeqifu.system.service;

import com.yeqifu.system.common.DataGridView;
import com.yeqifu.system.domain.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yeqifu.system.vo.DeptVo;

/**
* @Author: 落亦-
* @Date: 2020/2/4 10:32
*/
public interface DeptService extends IService<Dept>{

    /**
     * 查询所有部门
     * @param deptVo
     * @return
     */
    DataGridView queryAllDept(DeptVo deptVo);

    /**
     * 保存一个部门
     * @param dept
     * @return
     */
    Dept saveDept(Dept dept);

    /**
     * 查询最大排序码
     * @return
     */
    Integer queryDeptMaxOrderNum();
}
