package com.demo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails userDetails = User.withUsername("user")
				.password("pass123")
				.roles("read")
				.build();
		return new InMemoryUserDetailsManager(userDetails);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
