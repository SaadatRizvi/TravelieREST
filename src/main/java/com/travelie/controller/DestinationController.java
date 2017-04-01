package com.travelie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.travelie.JSON.JSONViews.DestinationView;
import com.travelie.entity.Destination;
import com.travelie.service.DestinationService;

@RestController
public class DestinationController {

	@Autowired
	DestinationService destinationLoginService;
	
	@JsonView(DestinationView.class)
	@RequestMapping("/destinations")
	public List<Destination> getAllAdmins(){
		return destinationLoginService.getDestinations();
	}
	
	@JsonView(DestinationView.class)
	@RequestMapping("/destinations/{theId}")
	public Destination getDestination (@PathVariable int theId){
		return destinationLoginService.getDestination(theId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/destinations")
	public void addDestination(@RequestBody Destination theDestination){
		destinationLoginService.saveDestination(theDestination);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/destinations/{id}")
	public void updateDestination(@RequestBody Destination theDestination){
		destinationLoginService.saveDestination(theDestination);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/destinations/{id}")
	public void deleteDestination(@PathVariable int id){
		destinationLoginService.deleteDestination(id);
	}
	
}
