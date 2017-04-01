package com.travelie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.travelie.JSON.JSONViews.TicketView;
import com.travelie.entity.Ticket;
import com.travelie.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	TicketService ticketLoginService;
	
	@JsonView(TicketView.class)
	@RequestMapping("/tickets")
	public List<Ticket> getAllAdmins(){
		return ticketLoginService.getTickets();
	}
	@JsonView(TicketView.class)	
	@RequestMapping("/tickets/{theId}")
	public Ticket getTicket (@PathVariable int theId){
		return ticketLoginService.getTicket(theId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/tickets")
	public void addTicket(@RequestBody Ticket theTicket){
		ticketLoginService.saveTicket(theTicket);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/tickets/{id}")
	public void updateTicket(@RequestBody Ticket theTicket){
		ticketLoginService.saveTicket(theTicket);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/tickets/{id}")
	public void deleteTicket(@PathVariable int id){
		ticketLoginService.deleteTicket(id);
	}
	
	
	
	
}
