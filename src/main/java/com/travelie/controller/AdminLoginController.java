package com.travelie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.travelie.JSON.JSONViews.AdminLoginView;
import com.travelie.entity.AdminLogin;
import com.travelie.service.AdminLoginService;

@RestController
public class AdminLoginController {

	@Autowired
	AdminLoginService adminLoginService;
	
	@JsonView(AdminLoginView.class)
	@RequestMapping("/admins")
	public List<AdminLogin> getAllAdmins(){
		return adminLoginService.getAdminLogins();
	}
	
	@JsonView(AdminLoginView.class)
	@RequestMapping("/admins/{theId}")
	public AdminLogin getAdminLogin (@PathVariable int theId){
		return adminLoginService.getAdminLogin(theId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/admins")
	public void addAdminLogin(@RequestBody AdminLogin theAdminLogin){
		adminLoginService.saveAdminLogin(theAdminLogin);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/admins/{id}")
	public void updateAdminLogin(@RequestBody AdminLogin theAdminLogin){
		adminLoginService.saveAdminLogin(theAdminLogin);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/admins/{id}")
	public void deleteAdminLogin(@PathVariable int id){
		adminLoginService.deleteAdminLogin(id);
	}
	
}
