package com.yeqifu.system.realm;

import com.yeqifu.system.common.ActiveUser;
import com.yeqifu.system.domain.User;
import com.yeqifu.system.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 落亦-
 * @Date: 2020/1/30 20:18
 */
public class UserRealm extends AuthenticatingRealm {

    @Autowired
    private UserService userService;

    @Override
    public String getName(){
        return this.getClass().getSimpleName();
    }

    /**
     * 对用户进行登陆认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = authenticationToken.getPrincipal().toString();
        User user = this.userService.queryUserByLoginName(userName);
        if (null!=user){
            ActiveUser activeUser = new ActiveUser();
            activeUser.setUser(user);
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activeUser,user.getPwd(), ByteSource.Util.bytes(user.getSalt()),getName());
            return info;
        }
        return null;
    }
}
