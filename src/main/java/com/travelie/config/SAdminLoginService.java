package com.travelie.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.travelie.dao.AdminLoginDAO;
import com.travelie.entity.AdminLogin;

public class SAdminLoginService implements UserDetailsService{
	
	private final AdminLoginDAO adminLoginDAO;

	private static Logger logger = Logger
			.getLogger(SAdminLoginService.class);
	
	public SAdminLoginService(AdminLoginDAO adminLoginDAO) {
		this.adminLoginDAO = adminLoginDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<AdminLogin> admins =adminLoginDAO.findByUserName(userName);
		if (admins != null){
			if (admins.size()> 1){
				logger.info("loadUserByUsername: More than one admin in list -- list.size()=: "+admins.size());
			}
			AdminLogin admin = admins.get(0);
			List<GrantedAuthority> authorities =
					new ArrayList<GrantedAuthority>();
					authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			
		
		
		return new User(admin.getUserName(),admin.getPassword(),authorities);
				
		}
		throw new UsernameNotFoundException(
				"User '"+userName+"' not found.");
	}
}
