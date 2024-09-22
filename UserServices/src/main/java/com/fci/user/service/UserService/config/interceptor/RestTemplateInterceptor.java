/**
 * 
 */
package com.fci.user.service.UserService.config.interceptor;

import java.io.IOException;
import java.util.logging.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

import lombok.extern.slf4j.Slf4j;

/**
 * com.rajan.user.service.UserService.config.interceptor DelL
 * @author Rajan kumar
 */
@Slf4j
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
	/*
	 * // @Autowired private OAuth2AuthorizedClientManager manager;
	 * 
	 * public RestTemplateInterceptor(OAuth2AuthorizedClientManager manager) {
	 * this.manager = manager; }
	 * 
	 * public ClientHttpResponse intercept(HttpRequest request, byte[] body,
	 * ClientHttpRequestExecution execution) throws IOException {
	 * log.info("hello interceptor..........."); String token =
	 * manager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId(
	 * "my-internal-client").principal("internal").build()) .getAccessToken()
	 * .getTokenValue();
	 * 
	 * log.info("rest templete interceptor : token {} ",token);
	 * request.getHeaders().add("Authorization","Bearer "+token); return
	 * execution.execute(request, body);
	 * 
	 * }
	 */

	private OAuth2AuthorizedClientManager manager;

//    private Logger logger= LoggerFactory.logger(RestTemplateInterceptor.class);

    public RestTemplateInterceptor(OAuth2AuthorizedClientManager manager) {
        this.manager = manager;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        String token = manager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build()).getAccessToken().getTokenValue();


        request.getHeaders().add("Authorization","Bearer "+token);
        return execution.execute(request,body);
    }
}
