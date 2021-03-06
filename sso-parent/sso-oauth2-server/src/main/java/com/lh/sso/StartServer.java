package com.lh.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/28
 */
@SpringBootApplication
@EnableResourceServer
public class StartServer {

    public static void main(String[] args) {
        SpringApplication.run(StartServer.class,args);
    }
}
