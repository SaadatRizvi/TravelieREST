package com.travelie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelie.dao.AdminLoginDAO;
import com.travelie.entity.AdminLogin;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private AdminLoginDAO adminLoginDAO;
	
	@Override
	public List<AdminLogin> getAdminLogins() {
		List<AdminLogin> adminLogins = new ArrayList<>();
		adminLoginDAO.findAll()
		.forEach(adminLogins::add);
		return adminLogins;
	}

	@Override
	public void saveAdminLogin(AdminLogin theAdminLogin) {
		adminLoginDAO.save(theAdminLogin);

	}

	@Override
	public AdminLogin getAdminLogin(int theId) {
		
		return adminLoginDAO.findOne(theId);
	}

	@Override
	public void deleteAdminLogin(int theId) {
		adminLoginDAO.delete(theId);

	}

	

}
