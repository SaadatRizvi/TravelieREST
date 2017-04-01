package com.travelie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelie.dao.RouteDAO;
import com.travelie.entity.Route;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteDAO routeDAO;
	
	@Override
	public List<Route> getRoutes() {
		List<Route> routes = new ArrayList<>();
		routeDAO.findAll()
		.forEach(routes::add);
		return routes;
	}

	@Override
	public void saveRoute(Route theRoute) {
		routeDAO.save(theRoute);

	}

	@Override
	public Route getRoute(int theId) {
		
		return routeDAO.findOne(theId);
	}

	@Override
	public void deleteRoute(int theId) {
		routeDAO.delete(theId);

	}


	
	
	}

