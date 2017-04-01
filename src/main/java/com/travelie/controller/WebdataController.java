package com.travelie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.travelie.JSON.JSONViews.WebdataView;
import com.travelie.entity.Webdata;
import com.travelie.service.WebdataService;

@RestController
public class WebdataController {

	@Autowired
	WebdataService webdataLoginService;
	
	@JsonView(WebdataView.class)
	@RequestMapping("/webdatas")
	public List<Webdata> getAllAdmins(){
		return webdataLoginService.getWebdatas();
	}
	@JsonView(WebdataView.class)	
	@RequestMapping("/webdatas/{theId}")
	public Webdata getWebdata (@PathVariable int theId){
		return webdataLoginService.getWebdata(theId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/webdatas")
	public void addWebdata(@RequestBody Webdata theWebdata){
		webdataLoginService.saveWebdata(theWebdata);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/webdatas/{id}")
	public void updateWebdata(@RequestBody Webdata theWebdata){
		webdataLoginService.saveWebdata(theWebdata);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/webdatas/{id}")
	public void deleteWebdata(@PathVariable int id){
		webdataLoginService.deleteWebdata(id);
	}
	
	
	
	
}
