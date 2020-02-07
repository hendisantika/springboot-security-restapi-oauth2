package com.hendisantika.springbootsecurityrestapioauth2.service;

import com.hendisantika.springbootsecurityrestapioauth2.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-security-restapi-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/02/20
 * Time: 06.48
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static final AtomicLong counter = new AtomicLong();

    private static List<User> users;

    static {
        users = getDummyUsers();
    }

}
