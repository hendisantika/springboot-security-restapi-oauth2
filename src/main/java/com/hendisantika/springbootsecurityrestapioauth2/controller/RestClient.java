package com.hendisantika.springbootsecurityrestapioauth2.controller;

import com.hendisantika.springbootsecurityrestapioauth2.model.AuthTokenInfo;
import com.hendisantika.springbootsecurityrestapioauth2.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-security-restapi-oauth2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/02/20
 * Time: 08.26
 */
@Slf4j
public class RestClient {
    public static final String REST_SERVICE_URI = "http://localhost:8080";
    public static final String AUTH_SERVER_URI = "http://localhost:8080/oauth2/token";
    public static final String CLIENT_ID = "my-trusted-client";
    public static final String CLIENT_SECRET = "secret";

    /**
     * HTTP Headers.
     */
    private static HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        return headers;
    }

    /**
     * Add HTTP Authorization header, using Basic-Authentication to send client-credentials.
     */
    private static HttpHeaders getHeadersWithClientCredentials() {
        String plainClientCredentials = CLIENT_ID + ":" + CLIENT_SECRET;
        String base64ClientCredentials = Base64.getEncoder()
                .encodeToString(plainClientCredentials.getBytes(StandardCharsets.UTF_8));

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + base64ClientCredentials);
        return headers;
    }

    /**
     * Add HTTP Authorization header with Bearer token.
     */
    private static HttpHeaders getHeadersWithBearerToken(String accessToken) {
        HttpHeaders headers = getHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        return headers;
    }

    /**
     * Send a POST request [on /oauth2/token] to get an access-token using client_credentials grant.
     */
    @SuppressWarnings({"unchecked"})
    private static AuthTokenInfo sendTokenRequest() {
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");
        body.add("scope", "read write");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, getHeadersWithClientCredentials());
        ResponseEntity<Map> response = restTemplate.exchange(AUTH_SERVER_URI, HttpMethod.POST, request, Map.class);
        Map<String, Object> map = response.getBody();
        AuthTokenInfo tokenInfo = null;

        if (map != null) {
            tokenInfo = new AuthTokenInfo();
            tokenInfo.setAccessToken((String) map.get("access_token"));
            tokenInfo.setTokenType((String) map.get("token_type"));
            tokenInfo.setExpiresIn(((Number) map.get("expires_in")).intValue());
            tokenInfo.setScope((String) map.get("scope"));
            log.info("Token Info: {}", tokenInfo);
        } else {
            log.info("No token received----------");
        }
        return tokenInfo;
    }

    /**
     * GET request to get list of all users.
     */
    private static void findAllUsers(AuthTokenInfo tokenInfo) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> request = new HttpEntity<>(getHeadersWithBearerToken(tokenInfo.getAccessToken()));

        ResponseEntity<List<User>> response = restTemplate.exchange(
                REST_SERVICE_URI + "/user",
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<>() {
                });

        List<User> listUser = response.getBody();

        if (listUser != null) {
            listUser.forEach(item ->
                    log.info("id {} name {} email {} age {}", item.getId(), item.getName(), item.getEmail(), item.getAge())
            );
        }
    }

    public static void main(String[] args) {
        AuthTokenInfo tokenInfo = sendTokenRequest();
        if (tokenInfo != null) {
            findAllUsers(tokenInfo);
        }
    }
}
