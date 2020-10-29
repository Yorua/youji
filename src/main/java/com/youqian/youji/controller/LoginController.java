package com.youqian.youji.controller;

import com.youqian.youji.entity.Users;
import com.youqian.youji.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("userLogin")
    public String userLogin(Users users, HttpSession session) {
        System.out.println(users.toString());
        Users userInfo=loginService.userLogin(users);
        System.out.println(userInfo);
        if (userInfo!=null) {
            session.setAttribute("info", userInfo);
            return "index";
        } else {
            session.setAttribute("info", "1");
            return "login";
        }
    }

    @RequestMapping("userReg")
    public @ResponseBody String userReg(Users users, HttpSession session) {
        System.out.println(users.toString());
        boolean userInfo=loginService.userReg(users);
        if (userInfo) {
            session.setAttribute("regInfo", users.getUserName());
            return "true";
        } else {
            session.setAttribute("regInfo", "1");
            return "false";
        }
    }
}
