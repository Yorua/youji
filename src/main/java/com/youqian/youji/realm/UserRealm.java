package com.youqian.youji.realm;

import com.youqian.youji.entity.Users;
import com.youqian.youji.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm  extends AuthorizingRealm {

    @Autowired
    private LoginService loginSerivce;

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
        //编写shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken)arg0;
        Users user = loginSerivce.findUserByName(token.getUsername());
        if(user==null)
            return null;    //shiro底层会抛出UnKnowAccountException
        //2.判断密码
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
