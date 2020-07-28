package com.lh.sso;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestMima
{
    public static void main(String[] args) {

        String encode = new BCryptPasswordEncoder().encode("123456");
        System.out.println("pwd is " + encode);



    }
}
