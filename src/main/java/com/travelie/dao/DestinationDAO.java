package com.travelie.dao;

import org.springframework.data.repository.CrudRepository;

import com.travelie.entity.Destination;

public interface DestinationDAO  extends CrudRepository<Destination, Integer> {

	
	
}
