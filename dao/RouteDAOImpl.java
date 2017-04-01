package com.travelie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.entity.Route;


@Repository
@Transactional
//change Query in every DAO implementation
public class RouteDAOImpl implements RouteDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<Route> getRoutes() {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Route> theQuery =
				currentSession.createQuery("from Route order by id", Route.class);
		
		List<Route> routes = theQuery.getResultList();
		
		return routes;
	}


	@Override
	public void saveRoute(Route theRoute) {
     Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theRoute);
		
		
		
	}


	@Override
	public Route getRoute(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Route theRoute = currentSession.get(Route.class, theId);
		
		
		return theRoute;
	}


	@Override
	public void deleteRoute(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Route> theQuery =
				currentSession.createQuery("delete from Route where id=:routeId");
		theQuery.setParameter("routeId", theId);
		
		theQuery.executeUpdate();
		
	}

}
