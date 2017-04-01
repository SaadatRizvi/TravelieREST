package com.travelie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelie.dao.DestinationDAO;
import com.travelie.entity.Destination;

@Service
public class DestinationServiceImpl implements DestinationService {

	@Autowired
	private DestinationDAO destinationDAO;
	
	@Override
	public List<Destination> getDestinations() {
		List<Destination> destinations = new ArrayList<>();
		destinationDAO.findAll()
		.forEach(destinations::add);
		return destinations;
	}

	@Override
	public void saveDestination(Destination theDestination) {
		destinationDAO.save(theDestination);

	}

	@Override
	public Destination getDestination(int theId) {
		
		return destinationDAO.findOne(theId);
	}

	@Override
	public void deleteDestination(int theId) {
		destinationDAO.delete(theId);

	}

	

}
