package com.lh.sso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/*@Configuration
// 声明为认证服务器
@EnableAuthorizationServer
public class MyAuthorizationServerConfigurer {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void configgure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client").secret(passwordEncoder.encode("csdn123456"))
                .authorizedGrantTypes("authorization_code").scopes("app")
                .redirectUris("http://www.baidu.com");
               *//* .and()
                .withClient("toutiao").secret(passwordEncoder.encode("toutiao123456"))
                .authorizedGrantTypes("authorization code,implicit").scopes("app")
                .redirectUris("http://www.baidu.com")*//*;

    }

}*/


/**
 * 配置认证服务器
 */
@Configuration
@EnableAuthorizationServer
public class MyAuthorizationServerConfigurerAdapter  extends AuthorizationServerConfigurerAdapter {

    // 注入 WebSecurityConfiguration 中配置的 BCryptPasswordEncoder
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
       // endpoints.tokenStore()
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
       // clients.withClientDetails()
        clients

                .inMemory()
                .withClient("client")
                // 还需要为 secret 加密
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("authorization_code")
                .scopes("app")
                .redirectUris("http://www.baidu.com");

    }

}
