package com.hendisantika.springbootsecurityrestapioauth2.model;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-security-restapi-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/02/20
 * Time: 06.46
 */

@Data
public class AuthTokenInfo {
    private String accessToken;
    private String tokenType;
    private String refreshToken;
    private int expiresIn;
    private String scope;
}
