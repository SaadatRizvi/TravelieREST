package com.travelie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.travelie.JSON.JSONViews;

import javax.persistence.OneToMany;

import java.util.Set;

import javax.persistence.CascadeType;


@Entity
@Table(name="vantype", uniqueConstraints = {
		@UniqueConstraint(columnNames = "id"),
		@UniqueConstraint(columnNames = "type") })
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class VanType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	@JsonView(JSONViews.PrimaryView.class)
	private Integer id;
	
	@Column(name="type", unique = true, nullable = false)
	@JsonView(JSONViews.VanTypeView.class)
	private String type;
	
	
	 @OneToMany(mappedBy="category",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 @JsonView(JSONViews.VanTypeView.class)
	    private Set<Van> vans;
		
	public Set<Van> getVans() {
		return vans;
	}




	public void setVans(Set<Van> vans) {
		this.vans = vans;
	}




	public VanType(){
		
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	@Override
	public String toString() {
		return "VanType [id=" + id + ", type=" + type + "]";
	}






	



	
	
	
	
}
