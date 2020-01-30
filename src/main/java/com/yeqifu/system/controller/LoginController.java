package com.yeqifu.system.controller;

import com.yeqifu.system.common.ActiveUser;
import com.yeqifu.system.common.ResultObj;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author: 落亦-
 * @Date: 2020/1/30 19:55
 */
@Controller
@RequestMapping("login")
public class LoginController {

    /**
     * 用户登录
     * @param loginname     用户名
     * @param password      密码
     * @return
     */
    @RequestMapping("doLogin")
    @ResponseBody
    public ResultObj doLogin(String loginname,String password){
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken loginToken = new UsernamePasswordToken(loginname,password);
            subject.login(loginToken);
//            ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
            String token = subject.getSession().getId().toString();

            //写入登陆日志

            return new ResultObj(200,"登陆成功",token);
        }catch (AuthorizationException e){
            e.printStackTrace();
            return new ResultObj(-1,"用户名或密码错误");
        }

    }

}
