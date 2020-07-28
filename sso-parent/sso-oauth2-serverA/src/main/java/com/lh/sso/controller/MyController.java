package com.lh.sso.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/28
 */
@Controller
public class MyController {

    //不需要登录的
    @GetMapping("index0")
    public String index0(){
        return "indexView";
    }

    //不需要登录的
    @GetMapping("page0")
    @ResponseBody
    public String page0(){
        return "page1View 不需要登录";
    }


    //需要登录的
    @GetMapping("index1")
    @ResponseBody
    public String index1(){
        return "indexView  需要登录的 ";
    }

    //需要登录的
    @GetMapping("page1")
    public String page1(HttpServletRequest request){

     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        request.setAttribute("authentication",authentication);
        return "page1View";
    }
}


