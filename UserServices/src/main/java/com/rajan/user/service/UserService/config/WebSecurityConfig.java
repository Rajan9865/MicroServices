  /**
 * 
 */
package com.rajan.user.service.UserService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * com.rajan.user.service.UserService.config
 *@author Rajan kumar
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {

	        security.authorizeHttpRequests()
	                .anyRequest()
	                .authenticated()
	                .and()
	                .oauth2ResourceServer()
	                .jwt();

	        return security.build();

	    }

}
