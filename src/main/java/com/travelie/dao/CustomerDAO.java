package com.travelie.dao;

import org.springframework.data.repository.CrudRepository;

import com.travelie.entity.Customer;

public interface CustomerDAO extends CrudRepository<Customer, Integer> {

	
	
}
