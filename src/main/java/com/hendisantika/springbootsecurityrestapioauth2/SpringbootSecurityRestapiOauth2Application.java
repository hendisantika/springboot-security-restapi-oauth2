package com.hendisantika.springbootsecurityrestapioauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootSecurityRestapiOauth2Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootSecurityRestapiOauth2Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityRestapiOauth2Application.class, args);
	}

}
