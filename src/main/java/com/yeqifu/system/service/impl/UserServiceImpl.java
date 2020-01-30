package com.yeqifu.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeqifu.system.domain.User;
import com.yeqifu.system.mapper.UserMapper;
import com.yeqifu.system.service.UserService;
/**
* @Author: 落亦-
* @Date: 2020/1/30 16:39
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    private Log log = LogFactory.getLog(UserServiceImpl.class);

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
}
