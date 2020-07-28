package com.lh.sso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class MyOauth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("csdn") // clientId, 可以类比为用户名
                .secret(passwordEncoder.encode("csdn123")) // secret， 可以类比为密码
                .authorizedGrantTypes("authorization_code")    // 授权类型，这里选择授权码
                .scopes("app") // 授权范围
                .autoApprove(true) // 自动认证
                .redirectUris("http://localhost:6882/login","http://localhost:6883/login") // 认证成功重定向URL
                .accessTokenValiditySeconds(10); // 超时时间，10s
    }

}
