package com.hendisantika.springbootsecurityrestapioauth2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.ClientDetailsService;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-security-restapi-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/02/20
 * Time: 06.53
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
    @Value("${oauth.resource.id}")
    private String resourceId;

    private ClientDetailsService clientDetailsService;
}
