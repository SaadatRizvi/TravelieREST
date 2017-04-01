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
@Table(name="driver")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Driver {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonView(JSONViews.PrimaryView.class)
	private Integer id;
	
	@Column(name="first_name")
	@JsonView(JSONViews.DriverView.class)
	private String firstName;
	
	@Column(name="last_name")
	@JsonView(JSONViews.DriverView.class)
	private String lastName;
	
	@Column(name="picture")
	@JsonView(JSONViews.DriverView.class)
	private String picture;
	
	@Column(name="cnic")
	@JsonView(JSONViews.DriverView.class)
	private String cnic;
	
	@Column(name="license_number")
	@JsonView(JSONViews.DriverView.class)
	private String licenseNumber;
	
	@Column(name="phonenumber")
	@JsonView(JSONViews.DriverView.class)
	private int phoneNumber;
	
	@Column(name="flagged")
	@JsonView(JSONViews.DriverView.class)
	private int flagged;
	
	//Booking.java   reference
	 @OneToMany(mappedBy="driver",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 @JsonView(JSONViews.DriverView.class)
	 private Set<Booking> bookings;
	
	 
	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public Driver() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCnic() {
		return cnic;
	}

	public void setCnic(String cnic) {
		this.cnic = cnic;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getFlagged() {
		return flagged;
	}

	public void setFlagged(int flagged) {
		this.flagged = flagged;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", picture=" + picture
				+ ", cnic=" + cnic + ", licenseNumber=" + licenseNumber + ", phoneNumber=" + phoneNumber + ", flagged="
				+ flagged + "]";
	}
	
	
}


