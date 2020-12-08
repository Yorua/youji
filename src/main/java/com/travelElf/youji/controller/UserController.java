package com.travelElf.youji.controller;

import com.travelElf.youji.common.result.ResultEntity;
import com.travelElf.youji.req.UserLoginReq;
import com.travelElf.youji.req.UserRegisterReq;
import com.travelElf.youji.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

@Controller
@RequestMapping("/travelElf/api/user")
public class UserController {

    @Resource
    IUserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public ResultEntity login(UserLoginReq req) {
        return userService.login(req);
    }

    @RequestMapping("/register")
    @ResponseBody
    public  ResultEntity register(UserRegisterReq req) {
        return userService.register(req);
    }



}
