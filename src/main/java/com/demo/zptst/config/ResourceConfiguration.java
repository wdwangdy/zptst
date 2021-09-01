package com.demo.zptst.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
@Configuration
@EnableResourceServer
public class ResourceConfiguration extends ResourceServerConfigurerAdapter{
	
		private static final String RESOURCE_IDS = "AuthResource";
		
		@Override
		public void configure(ResourceServerSecurityConfigurer resources) {
		    resources.resourceId(RESOURCE_IDS).stateless(true);
		}
		
		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
				.antMatchers("/user/update","/user/delete").hasRole("ADMIN")
				.antMatchers("/user/get","/user/getFollowers","/user/getNearByFriends","/user/create").hasAnyRole("ADMIN","USER");
		}
}
