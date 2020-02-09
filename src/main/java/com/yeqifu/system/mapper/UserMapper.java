package com.yeqifu.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeqifu.system.domain.User;
import org.apache.ibatis.annotations.Param;

/**
* @Author: 落亦-
* @Date: 2020/1/30 16:39
*/
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询用户最大排序码
     * @return
     */
    Integer queryUserMaxOrderNum();

    /**
     * 保存用户和角色的关系
     * @param uid
     * @param rid
     */
    void saveUserRole(@Param("uid") Integer uid, @Param("rid") Integer rid);
}