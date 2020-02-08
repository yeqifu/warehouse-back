package com.yeqifu.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeqifu.system.common.DataGridView;
import com.yeqifu.system.domain.Dept;
import com.yeqifu.system.mapper.DeptMapper;
import com.yeqifu.system.service.DeptService;
import com.yeqifu.system.vo.DeptVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
* @Author: 落亦-
* @Date: 2020/2/4 10:32
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService{

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public DataGridView queryAllDept(DeptVo deptVo) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(deptVo.getTitle()),"title",deptVo.getTitle());
        queryWrapper.orderByAsc("ordernum");
        List<Dept> depts = this.deptMapper.selectList(queryWrapper);
        return new DataGridView(Long.valueOf(depts.size()),depts);
    }

    @CachePut(cacheNames = "com.yeqifu.system.service.impl.DeptServiceImpl",key = "#result.id")
    @Override
    public Dept saveDept(Dept dept) {
        deptMapper.insert(dept);
        return dept;
    }

    @Override
    public Integer queryDeptMaxOrderNum() {
        return deptMapper.queryDeptMaxOrderNum();
    }

    @CachePut(cacheNames = "com.yeqifu.system.service.impl.DeptServiceImpl",key = "#result.id")
    @Override
    public Dept updateDept(Dept dept) {
        this.deptMapper.updateById(dept);
        return dept;
    }

    @Override
    public Integer queryDeptChildrenCountById(Integer id) {
        return this.deptMapper.queryDeptChildrenCountById(id);
    }

    @Cacheable(cacheNames = "com.yeqifu.system.service.impl.DeptServiceImpl",key = "#id")
    @Override
    public Dept getById(Serializable id) {
        return super.getById(id);
    }

    @CacheEvict(cacheNames = "com.yeqifu.system.service.impl.DeptServiceImpl",key = "#id")
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }
}
