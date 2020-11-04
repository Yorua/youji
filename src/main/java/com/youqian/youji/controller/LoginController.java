package com.youqian.youji.controller;

import com.youqian.youji.entity.Users;
import com.youqian.youji.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Resource
    LoginService loginService;

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("register")
    public String register() {
        return "register";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("userLogin")
    public String userLogin(Users users, Model model) {
        System.out.println(users.toString());
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(users.getUsername(),users.getPassword());
        //3.执行登录方法
        try {
            subject.login(token);
            model.addAttribute("user",token.getUsername());
            return "redirect:/index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

//    @RequestMapping("userLogin")
//    public String userLogin(Users users, HttpSession session) {
//        System.out.println(users.toString());
//        Users userInfo=loginService.userLogin(users);
//        System.out.println(userInfo);
//        if (userInfo!=null) {
//            session.setAttribute("info", userInfo);
//            return "index";
//        } else {
//            session.setAttribute("info", "1");
//            return "login";
//        }
//    }

    @RequestMapping("userReg")
    public @ResponseBody String userReg(Users users, HttpSession session) {
        System.out.println(users.toString());
        boolean userInfo=loginService.userReg(users);
        if (userInfo) {
            session.setAttribute("regInfo", users.getUsername());
            return "true";
        } else {
            session.setAttribute("regInfo", "1");
            return "false";
        }
    }
}
