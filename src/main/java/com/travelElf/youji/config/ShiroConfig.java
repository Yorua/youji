package com.travelElf.youji.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.travelElf.youji.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *    常用的过滤器：
         *       anon: 无需认证（登录）可以访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用rememberMe的功能可以直接访问
         *       perms： 该资源必须得到资源权限才可以访问
         *       role: 该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<String,String>();
        filterMap.put("/resources/**", "anon");
        filterMap.put("/travelElf/api/user/toLogin", "anon");
        filterMap.put("/travelElf/api/user/login", "anon");
        filterMap.put("/travelElf/api/user/register", "anon");
        filterMap.put("/travelElf/api/user/toRegister", "anon");
        filterMap.put("/**", "authc");

        shiroFilterFactoryBean.setLoginUrl("/travelElf/api/user/toLogin");
        shiroFilterFactoryBean.setSuccessUrl("/travelElf/api/index");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到未授权页面
        //filterMap.put("/url", "perms[user:url]");
        //设置未授权提示页面
        //shiroFilterFactoryBean.setUnauthorizedUrl("/url");

        return shiroFilterFactoryBean;
    }

    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean(name="userRealm")
    public UserRealm userRealm(){
        return  new UserRealm();
    }

    /**
     * 配置ShiroDialect，用于thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

}
