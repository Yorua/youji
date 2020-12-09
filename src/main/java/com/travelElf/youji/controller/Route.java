package com.travelElf.youji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/travelElf/api/toPage")
public class Route {
    private String url = null;

    @RequestMapping("/user/{page}")
    public String toUserPage(@PathVariable String page) {
        url = "user/" + page;
        return url;
    }

    @RequestMapping("/{page}")
    public String toIndex(@PathVariable String page) {
        return page;
    }
}
