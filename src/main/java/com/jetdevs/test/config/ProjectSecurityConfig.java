package com.jetdevs.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.jetdevs.test.constants.GeneralConstants;

@Configuration
public class ProjectSecurityConfig {

	Logger logger = LoggerFactory.getLogger(ProjectSecurityConfig.class);

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(request -> request
						.requestMatchers("/api/product/upload").hasRole(GeneralConstants.ROLE_ADMIN)
						.requestMatchers("/api/file/get-all-files").hasAnyRole(GeneralConstants.ROLE_ADMIN, GeneralConstants.ROLE_USER)
						.requestMatchers("/api/product/get-file-by-id/*").hasAnyRole(GeneralConstants.ROLE_ADMIN, GeneralConstants.ROLE_USER)
						.requestMatchers("/api/file/delete-file-by-id/*").hasRole(GeneralConstants.ROLE_ADMIN)
						.requestMatchers("/api/user/register", "/swagger-ui/**", "/v3/**").permitAll());
		http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
