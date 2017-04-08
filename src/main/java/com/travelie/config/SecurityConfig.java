package com.travelie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.travelie.dao.AdminLoginDAO;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AdminLoginDAO adminLoginDAO;
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http.csrf().disable();   // csrf is disabled to easily allow Angular to send form data without any csrf token
		
		http
		.authorizeRequests()
		.antMatchers("/**").hasRole("ADMIN")
		//.antMatchers("/**").permitAll()
		.and()
        .httpBasic();
		
	}


	@Override
	protected void configure(
			AuthenticationManagerBuilder auth) throws Exception{
	
		auth
		.userDetailsService(new SAdminLoginService(adminLoginDAO));
		
	}
	
}
