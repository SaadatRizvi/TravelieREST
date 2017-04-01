package com.travelie.dao;

import org.springframework.data.repository.CrudRepository;

import com.travelie.entity.Ticket;

public interface TicketDAO extends CrudRepository<Ticket, Integer>{


	
}
