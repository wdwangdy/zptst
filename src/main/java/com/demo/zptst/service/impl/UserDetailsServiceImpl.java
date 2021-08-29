package com.demo.zptst.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if("admin".equals(username)) {
			return User.withUsername("admin").password(passwordEncoder().encode("123456")).roles("ADMIN").build();
		}else {
			return User.withUsername("user").password(passwordEncoder().encode("123456")).roles("USER").build();
		}
	}
}
