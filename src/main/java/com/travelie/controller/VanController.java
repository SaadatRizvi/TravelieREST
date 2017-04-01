package com.travelie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.travelie.JSON.JSONViews.VanView;
import com.travelie.entity.Van;
import com.travelie.service.VanService;

@RestController
public class VanController {

	@Autowired
	VanService vanLoginService;
	
	@JsonView(VanView.class)
	@RequestMapping("/vans")
	public List<Van> getAllAdmins(){
		return vanLoginService.getVans();
	}
	
	@JsonView(VanView.class)
	@RequestMapping("/availableVans")
	public List<Van> getAllAvailableDrivers(){
		return vanLoginService.getAvailableVans();
	}
	
	@JsonView(VanView.class)
	@RequestMapping("/vans/{theId}")
	public Van getVan (@PathVariable int theId){
		return vanLoginService.getVan(theId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/vans")
	public void addVan(@RequestBody Van theVan){
		vanLoginService.saveVan(theVan);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/vans/{id}")
	public void updateVan(@RequestBody Van theVan){
		vanLoginService.saveVan(theVan);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/vans/{id}")
	public void deleteVan(@PathVariable int id){
		vanLoginService.deleteVan(id);
	}
	
	
	
	
}
