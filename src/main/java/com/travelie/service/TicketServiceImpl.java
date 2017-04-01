package com.travelie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelie.dao.TicketDAO;
import com.travelie.entity.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDAO ticketDAO;
	
	@Override
	public List<Ticket> getTickets() {
		List<Ticket> tickets = new ArrayList<>();
		ticketDAO.findAll()
		.forEach(tickets::add);
		return tickets;
	}

	@Override
	public void saveTicket(Ticket theTicket) {
		ticketDAO.save(theTicket);

	}

	@Override
	public Ticket getTicket(int theId) {
		
		return ticketDAO.findOne(theId);
	}

	@Override
	public void deleteTicket(int theId) {
		ticketDAO.delete(theId);

	}


	
	
	}

