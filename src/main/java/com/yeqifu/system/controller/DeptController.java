package com.yeqifu.system.controller;

import com.yeqifu.system.common.Constant;
import com.yeqifu.system.common.DataGridView;
import com.yeqifu.system.common.ResultObj;
import com.yeqifu.system.domain.Dept;
import com.yeqifu.system.service.DeptService;
import com.yeqifu.system.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 落亦-
 * @Date: 2020/2/4 10:34
 */
@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门
     * @param deptVo    deptVo
     * @return          DataGridView
     */
    @RequestMapping("loadAllDept")
    public Object loadAllDept(DeptVo deptVo){
        return deptService.queryAllDept(deptVo);
    }

    /**
     * 添加部门
     * @param dept
     * @return      ResultObj
     */
    @PostMapping("addDept")
    public ResultObj addDept(Dept dept){
        try {
            dept.setSpread(Constant.SPREAD_FALSE);
            dept.setAvailable(Constant.AVAILABLE_TRUE);

            deptService.saveDept(dept);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 查询最大排序码
     * @return      排序码
     */
    @GetMapping("queryDeptMaxOrderNum")
    public Object queryDeptMaxOrderNum(){
        Integer maxValue = deptService.queryDeptMaxOrderNum();
        return new DataGridView(maxValue+1);
    }

    /**
     * 修改部门
     * @param dept
     * @return
     */
    @PostMapping("updateDept")
    public ResultObj updateDept(Dept dept){
        try {
            deptService.updateDept(dept);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }

    }

    /**
     * 通过ID查询出部门信息
     * @param id
     * @return
     */
    @GetMapping("getDeptById")
    public Object getDeptById(Integer id){
        return new DataGridView(deptService.getById(id));
    }

    /**
     * 根据部门ID查询其子部门的个数
     * @param id
     * @return
     */
    @GetMapping("getDeptChildrenCountById")
    public Object getDeptChildrenCountById(Integer id){
        Integer count = deptService.queryDeptChildrenCountById(id);
        return new DataGridView(count);
    }

    /**
     * 删除部门
     * @param id    部门ID
     * @return      ResultObj
     */
    @PostMapping("deleteDept")
    public ResultObj deleteDept(Integer id){
        try {
            deptService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }


}
