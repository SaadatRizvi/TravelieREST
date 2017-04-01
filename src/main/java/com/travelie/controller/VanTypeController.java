package com.travelie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.travelie.JSON.JSONViews.VanTypeView;
import com.travelie.entity.VanType;
import com.travelie.service.VanTypeService;

@RestController
public class VanTypeController {

	@Autowired
	VanTypeService vanTypeLoginService;
	
	@JsonView(VanTypeView.class)
	@RequestMapping("/vanTypes")
	public List<VanType> getAllAdmins(){
		return vanTypeLoginService.getVanTypes();
	}
	@JsonView(VanTypeView.class)	
	@RequestMapping("/vanTypes/{theId}")
	public VanType getVanType (@PathVariable int theId){
		return vanTypeLoginService.getVanType(theId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/vanTypes")
	public void addVanType(@RequestBody VanType theVanType){
		vanTypeLoginService.saveVanType(theVanType);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/vanTypes/{id}")
	public void updateVanType(@RequestBody VanType theVanType){
		vanTypeLoginService.saveVanType(theVanType);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/vanTypes/{id}")
	public void deleteVanType(@PathVariable int id){
		vanTypeLoginService.deleteVanType(id);
	}
	
	
	
	
}
