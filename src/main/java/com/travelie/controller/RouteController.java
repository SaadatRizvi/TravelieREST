package com.travelie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.travelie.JSON.JSONViews.RouteView;
import com.travelie.entity.Route;
import com.travelie.service.RouteService;

@RestController
public class RouteController {

	@Autowired
	RouteService routeLoginService;
	
	@JsonView(RouteView.class)
	@RequestMapping("/routes")
	public List<Route> getAllAdmins(){
		return routeLoginService.getRoutes();
	}
		
	@JsonView(RouteView.class)
	@RequestMapping("/routes/{theId}")
	public Route getRoute (@PathVariable int theId){
		return routeLoginService.getRoute(theId);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/routes")
	public void addRoute(@RequestBody Route theRoute){
		routeLoginService.saveRoute(theRoute);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/routes/{id}")
	public void updateRoute(@RequestBody Route theRoute){
		routeLoginService.saveRoute(theRoute);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/routes/{id}")
	public void deleteRoute(@PathVariable int id){
		routeLoginService.deleteRoute(id);
	}
	
	
	
	
}
