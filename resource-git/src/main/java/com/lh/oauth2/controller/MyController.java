package com.lh.oauth2.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/28
 */

@RestController
public class MyController {

    @GetMapping("/view")
    public String view(String json) {

        return "view  id : " + json;
    }

    @GetMapping("/order")
    public String getOrder(String json) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "order id : " + authentication;
    }

    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        System.out.print("authentication is " + authentication);
        return authentication;
    }

    //http://192.168.110.1:7500/client/login&response_type=code&state=EvVqAV
   @GetMapping("/login")
    public String login(String response_type, String state) {
        System.out.print("response_type is " + response_type + " and state is" + state);
        return "ok";
    }


    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/auth/admin")
    public Object adminAuth() {
        return "Has admin auth!";
    }
}