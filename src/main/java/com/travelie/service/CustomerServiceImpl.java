package com.travelie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelie.dao.CustomerDAO;
import com.travelie.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<>();
		customerDAO.findAll()
		.forEach(customers::add);
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		customerDAO.save(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {
		
		return customerDAO.findOne(theId);
	}

	@Override
	public void deleteCustomer(int theId) {
		customerDAO.delete(theId);

	}

	

}
