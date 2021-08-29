package com.demo.zptst.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfiguration extends AuthorizationServerConfigurerAdapter{

	private static final String RESOURCE_IDS = "AuthResource";
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
    @Autowired
    private UserDetailsService userDetailsService;

	@Override
	public void  configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.userDetailsService(userDetailsService)
				 .authenticationManager(authenticationManager)
        		 .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
	}
	
	@Override
	public void  configure(AuthorizationServerSecurityConfigurer Security) throws Exception {
		Security.allowFormAuthenticationForClients();
	}
	
	@Override
	public void  configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			   .withClient("client")
			   .secret(passwordEncoder.encode("123456"))
			   .authorizedGrantTypes("password","refresh_token")
			   .scopes("select")
			   .authorities("oauth2")
			   .resourceIds(RESOURCE_IDS)
			   .accessTokenValiditySeconds(1200)
			   .refreshTokenValiditySeconds(5000);

	}
}
