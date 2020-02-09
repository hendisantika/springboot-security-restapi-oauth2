package com.hendisantika.springbootsecurityrestapioauth2.controller;

import com.hendisantika.springbootsecurityrestapioauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-security-restapi-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/02/20
 * Time: 08.30
 */
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

}
