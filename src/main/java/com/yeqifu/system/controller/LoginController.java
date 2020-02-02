package com.yeqifu.system.controller;

import com.yeqifu.system.common.ActiveUser;
import com.yeqifu.system.common.Constant;
import com.yeqifu.system.common.MenuTreeNode;
import com.yeqifu.system.common.ResultObj;
import com.yeqifu.system.domain.Loginfo;
import com.yeqifu.system.domain.Menu;
import com.yeqifu.system.domain.User;
import com.yeqifu.system.service.LoginfoService;
import com.yeqifu.system.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


/**
 * @Author: 落亦-
 * @Date: 2020/1/30 19:55
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private LoginfoService loginfoService;

    /**
     * 用户登录
     * @param loginname     用户名
     * @param password      密码
     * @return
     */
    @RequestMapping("doLogin")
    @ResponseBody
    public ResultObj doLogin(String loginname, String password, HttpServletRequest request){
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken loginToken = new UsernamePasswordToken(loginname,password);
            subject.login(loginToken);
            //得到shiro的sessionid==token
            String token = subject.getSession().getId().toString();

            //写入登陆日志
            ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
            User user = activeUser.getUser();
            Loginfo loginfo = new Loginfo();
            loginfo.setLoginname(user.getName()+"-"+user.getLoginname());
            loginfo.setLoginip(request.getRemoteAddr());
            loginfo.setLogintime(new Date());
            loginfoService.save(loginfo);

            return new ResultObj(200,"登陆成功",token);
        }catch (AuthorizationException e){
            e.printStackTrace();
            return new ResultObj(-1,"用户名或密码错误");
        }
    }





    /**
     * 加载主页菜单
     * @return
     */
    @RequestMapping("loadIndexMenu")
    @ResponseBody
    public Object loadIndexMenu(){
        //得到当前登陆的用户
        Subject subject = SecurityUtils.getSubject();
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        if (null==activeUser){
            return null;
        }
        User user = activeUser.getUser();
        List<Menu> menus = null;
        if (Constant.USER_TYPE_SUPER.equals(user.getType())){
            //超级管理员 拥有所有菜单权限
            menus = menuService.queryAllMenuForList();
        }else {
            //普通用户  根据用户ID来的菜单权限
            menus = menuService.queryMenuForListByUserId(user.getId());
        }

        List<MenuTreeNode> treeNodes = new ArrayList<>();

        for (Menu menu : menus) {
            Boolean spread = menu.getSpread().equals(Constant.AVAILABLE_TRUE)?true:false;
            treeNodes.add(new MenuTreeNode(menu.getId(),menu.getPid(),menu.getTitle(),menu.getHref(),menu.getIcon(),spread,menu.getTarget(),menu.getTypeCode()));
        }

        List<MenuTreeNode> nodes = MenuTreeNode.MenuTreeNodeBuilder.build(treeNodes, 0);
        Map<String,Object> res = new HashMap<>();
        for (MenuTreeNode n : nodes) {
            res.put(n.getTypecode(),n);
        }

        return res;
    }

    /**
     * 验证当前token是否登陆
     * @return
     */
    @RequestMapping("checkLogin")
    @ResponseBody
    public ResultObj checkLogin(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            return ResultObj.IS_LOGIN;
        }else {
            return ResultObj.UN_LOGIN;
        }
    }




}
