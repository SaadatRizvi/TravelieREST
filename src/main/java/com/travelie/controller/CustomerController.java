package com.travelie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.travelie.JSON.JSONViews;
import com.travelie.entity.Customer;
import com.travelie.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerLoginService;
	
	@JsonView(JSONViews.CustomerView.class)
	@RequestMapping("/customers")
	public List<Customer> getAllAdmins(){
		return customerLoginService.getCustomers();
	}
	
	@JsonView(JSONViews.CustomerView.class)
	@RequestMapping("/customers/{theId}")
	public Customer getCustomer (@PathVariable int theId){
		return customerLoginService.getCustomer(theId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/customers")
	public void addCustomer(@RequestBody Customer theCustomer){
		
		//return theCustomer;
		customerLoginService.saveCustomer(theCustomer);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/customers/{id}")
	public void updateCustomer(@RequestBody Customer theCustomer){
		customerLoginService.saveCustomer(theCustomer);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/customers/{id}")
	public void deleteCustomer(@PathVariable int id){
		customerLoginService.deleteCustomer(id);
	}
	
}
