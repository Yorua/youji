package com.youqian.youji.controller;

import com.youqian.youji.entity.User;
import com.youqian.youji.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/travelElf/api/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("login")
    public String login(User user, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            session.setAttribute("user",token.getUsername());
            return "redirect:/travelElf/api/user/index";
        } catch (UnknownAccountException e) {
            session.setAttribute("msg", "用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            session.setAttribute("msg", "密码错误");
            return "login";
        }
    }

    @RequestMapping("register")
    public @ResponseBody String register(User user, HttpSession session) {
        System.out.println(user.toString());
        boolean userInfo= userService.register(user);
        if (userInfo) {
            session.setAttribute("regInfo", user.getUsername());
            return "true";
        } else {
            session.setAttribute("regInfo", "1");
            return "false";
        }
    }

    @RequestMapping({" ","/toLogin"})
    public String login() {
        return "login";
    }

    @RequestMapping("toRegister")
    public String register() {
        return "register";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("update")
    public String update() {
        return "user/update";
    }
}
