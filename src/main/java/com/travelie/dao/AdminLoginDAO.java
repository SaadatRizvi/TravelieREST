package com.travelie.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.travelie.entity.AdminLogin;

public interface AdminLoginDAO extends CrudRepository<AdminLogin, Integer> {

	public List<AdminLogin> findByUserName(String userName);
}
