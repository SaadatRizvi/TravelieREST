package com.travelie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.travelie.JSON.JSONViews.DriverView;
import com.travelie.entity.Driver;
import com.travelie.service.DriverService;

@RestController
public class DriverController {

	@Autowired
	DriverService driverLoginService;
	
	@JsonView(DriverView.class)
	@RequestMapping("/drivers")
	public List<Driver> getAllAdmins(){
		return driverLoginService.getDrivers();
	}
	
	@JsonView(DriverView.class)
	@RequestMapping("/availableDrivers")
	public List<Driver> getAllAvailableDrivers(){
		return driverLoginService.getAvailableDrivers();
	}
	
	@JsonView(DriverView.class)
	@RequestMapping("/drivers/{theId}")
	public Driver getDriver (@PathVariable int theId){
		return driverLoginService.getDriver(theId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/drivers")
	public void addDriver(@RequestBody Driver theDriver){
		driverLoginService.saveDriver(theDriver);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/drivers/{id}")
	public void updateDriver(@RequestBody Driver theDriver){
		driverLoginService.saveDriver(theDriver);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/drivers/{id}")
	public void deleteDriver(@PathVariable int id){
		driverLoginService.deleteDriver(id);
	}
	
	
	
	
}
