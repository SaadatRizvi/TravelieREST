package com.travelie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelie.dao.DriverDAO;
import com.travelie.entity.Driver;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverDAO driverDAO;
	
	@Override
	public List<Driver> getDrivers() {
		List<Driver> drivers = new ArrayList<>();
		driverDAO.findAll()
		.forEach(drivers::add);
		return drivers;
	}

	@Override
	public void saveDriver(Driver theDriver) {
		driverDAO.save(theDriver);

	}

	@Override
	public Driver getDriver(int theId) {
		
		return driverDAO.findOne(theId);
	}

	@Override
	public void deleteDriver(int theId) {
		driverDAO.delete(theId);

	}

	@Override
	public List<Driver> getAvailableDrivers() {
		 List <Driver> drivers =getDrivers();
			
			List<Driver> availableDrivers = new ArrayList<Driver>();
			
			for (Driver temp: drivers){
				
				if (temp.getFlagged()==0){
					availableDrivers.add(temp);
				}
			}
			return availableDrivers;
		}
	
	
	}

