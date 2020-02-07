package com.hendisantika.springbootsecurityrestapioauth2.service;

import com.hendisantika.springbootsecurityrestapioauth2.model.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-security-restapi-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/02/20
 * Time: 06.47
 */
public interface UserService {

    List<User> findAllUsers();
}