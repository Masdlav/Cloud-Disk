package com.networkDisk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class UserController {

    @GetMapping("/login")
    public String login(){
        log.info("进入登录页面");
        return "login";
    }

    @GetMapping("register")
    public void register(){

    }
}
