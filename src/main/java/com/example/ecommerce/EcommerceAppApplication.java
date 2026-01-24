package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class EcommerceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceAppApplication.class, args);
	}
	
	@Configuration
	public class SecurityConfig extends WebSecurityConfigurerAdapter {

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable()       // disable CSRF for testing
	            .authorizeRequests()
	            .anyRequest().permitAll();  // allow all requests
	    }
	}

}
