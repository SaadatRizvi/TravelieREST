package com.travelie.dao;

import org.springframework.data.repository.CrudRepository;

import com.travelie.entity.Booking;

public interface BookingDAO extends CrudRepository<Booking, Integer> {

	
	
}
