package com.yeqifu.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeqifu.system.common.AppUtils;
import com.yeqifu.system.common.Constant;
import com.yeqifu.system.common.DataGridView;
import com.yeqifu.system.common.MD5Utils;
import com.yeqifu.system.domain.Dept;
import com.yeqifu.system.domain.User;
import com.yeqifu.system.mapper.UserMapper;
import com.yeqifu.system.service.DeptService;
import com.yeqifu.system.service.UserService;
import com.yeqifu.system.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Author: 落亦-
* @Date: 2020/1/30 16:39
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    private Log log = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;


    /**
     * 通过用户登录名去查询用户
     * @param loginname     用户登录名
     * @return              User
     */
    @Override
    public User queryUserByLoginName(String loginname) {
        UserMapper userMapper = this.getBaseMapper();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isBlank(loginname)){
            log.error("登陆名不能为空");
            return null;
        }
        queryWrapper.eq("loginname",loginname);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

    /**
     * 查询所有角色
     * @param userVo
     * @return          DataGridView
     */
    @Override
    public DataGridView queryAllUser(UserVo userVo) {
        IPage<User> page = new Page<>(userVo.getPage(),userVo.getLimit());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",Constant.USER_TYPE_NORMAL);
        queryWrapper.eq(null!=userVo.getDeptid(),"deptid",userVo.getDeptid());
        queryWrapper.like(StringUtils.isNotBlank(userVo.getName()),"name",userVo.getName());
        queryWrapper.like(StringUtils.isNotBlank(userVo.getAddress()),"address",userVo.getAddress());
        queryWrapper.like(StringUtils.isNotBlank(userVo.getRemark()),"remark",userVo.getRemark());
        queryWrapper.orderByDesc("ordernum");
        userMapper.selectPage(page,queryWrapper);
        List<User> records = page.getRecords();
        //通过工具类获得deptService
        DeptService deptService = AppUtils.getContext().getBean(DeptService.class);
        //通过工具类获得userService
        UserService userService = AppUtils.getContext().getBean(UserService.class);
        for (User record : records) {
            if (null!=record.getDeptid()){
                Dept dept = deptService.getById(record.getDeptid());
                record.setDeptname(dept.getTitle());
            }
            if (null!=record.getMgr()){
                User user = userService.getById(record.getMgr());
                record.setMgrname(user.getName());
            }
        }
        return new DataGridView(page.getTotal(),records);
    }

    /**
     * 添加一个用户
     * @param user  用户实体类
     * @return      user
     */
    @Override
    public User saveUser(User user) {
        user.setSalt(MD5Utils.createUUID());
        user.setPwd(MD5Utils.md5(Constant.DEFAULT_PASSWORD,user.getSalt(),2));
        user.setImgpath(Constant.DEFAULT_IMAGE);
        userMapper.insert(user);
        return user;
    }

    /**
     * 更新一个用户
     * @param user  用户实体类
     * @return      user
     */
    @Override
    public User updateUser(User user) {
        userMapper.updateById(user);
        return user;
    }
}
