/**
 * 
 */
package src.main.java.com.rajan.gateway.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * com.fci.gateway.gateway.config DelL
 * @author Rajan kumar
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	 @Bean
	    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {

	        httpSecurity
	                .authorizeExchange()
	                .anyExchange()
	                .authenticated()
	                .and()
	                .oauth2Client()
	                .and()
	                .oauth2ResourceServer()
	                .jwt();


	        return httpSecurity.build();
	 }

}
