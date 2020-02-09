package com.hendisantika.springbootsecurityrestapioauth2.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-security-restapi-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/02/20
 * Time: 08.26
 */
public class RestClient {
    public static final String REST_SERVICE_URI = "http://localhost:8080/Spring-Boot-Security-RestAPI-OAuth2";

    public static final String AUTH_SERVER_URI = "http://localhost:8080/Spring-Boot-Security-RestAPI-OAuth2/oauth" +
            "/token";

    public static final String QPM_PASSWORD_GRANT = "?grant_type=password&username=henry&password=abc123";

    public static final String QPM_ACCESS_TOKEN = "?access_token=";

    /*
     * HTTP Headers.
     */
    private static HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }
}
