package com.hendisantika.springbootsecurityrestapioauth2.model;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-security-restapi-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/02/20
 * Time: 06.45
 */
@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private int age;
}
