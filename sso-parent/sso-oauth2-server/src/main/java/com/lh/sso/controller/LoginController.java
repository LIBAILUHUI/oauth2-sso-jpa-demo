package com.lh.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/28
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    public String login(){
        return "loginView";
    }
}
