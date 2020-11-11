package com.youqian.youji.realm;

import com.youqian.youji.entity.User;
import com.youqian.youji.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm  extends AuthorizingRealm {

    @Autowired
    private UserService loginSerivce;

    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        System.out.println("授权...");
        //给资源进行授权
        //SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        //info.addStringPermission("user:add");
        //到数据库查询当前登录用户的授权字符串
        //获取当前登录用户
        //Subject subject = SecurityUtils.getSubject();
        //Users user = (Users)subject.getPrincipal();
        //Users dbUser = loginSerivce.findUserById(user.getUserId());
        //info.addStringPermission(dbUser.getPerms());
        //return info;
        return  null;
    }

    /**
     * 执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        System.out.println("认证...");
        UsernamePasswordToken token = (UsernamePasswordToken)arg0;
        User user = loginSerivce.findUserByName(token.getUsername());
        if(user==null)
            return null;
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
