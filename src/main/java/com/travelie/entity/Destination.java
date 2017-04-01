package com.travelie.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.travelie.JSON.JSONViews;

@Entity
@Table(name="destination")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Destination {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonView(JSONViews.PrimaryView.class)
	private Integer id;
	
	@Column(name="location", unique = true, nullable = false)
	@JsonView(JSONViews.DestinationView.class)
	private String location;
	
	
	@OneToMany(mappedBy="destination",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonView(JSONViews.DestinationView.class)
    private Set<Route> routes;
	
	
	public Set<Route> getRoutes() {
		return routes;
	}


	public void setRoutes(Set<Route> routes) {
		this.routes = routes;
	}




	public Destination(){
		
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	@Override
	public String toString() {
		return "Destination [id=" + id + ", location=" + location + "]";
	}


	



	
	
	
	
}
