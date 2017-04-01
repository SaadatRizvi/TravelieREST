package com.travelie.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.travelie.JSON.JSONViews;

@Entity
@Table(name="van")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Van {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonView(JSONViews.PrimaryView.class)
	private Integer id;
	
	@Column(name="vehicle_registration")
	@JsonView(JSONViews.VanView.class)
	private String vehicleRegistration;
	
	@Column(name="vehicle_type")
	@JsonView(JSONViews.VanView.class)
	private String vehicleType;
	
	@Column(name="total_seats")
	@JsonView(JSONViews.VanView.class)
	private int totalSeats;
	
	@ManyToOne
	@JoinColumn(name="vancategory_id")
	@JsonView(JSONViews.VanView.class)
	private VanType category;
	
	@Transient
	private String vanTypeCategory;
	
	@Column(name="flagged")
	@JsonView(JSONViews.VanView.class)
	private int flagged;	
	
	//Booking.java   reference
	 @OneToMany(mappedBy="van",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 @JsonView(JSONViews.VanView.class)
	    private Set<Booking> bookings;
	
	 	 
	
	public Set<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}


	public Van(){
		//vanTypeCategory = category.getType();        
	}


	public String getVanTypeCategory() {
		return vanTypeCategory;
	}


	public void setVanTypeCategory(String vanTypeCategory) {
		this.vanTypeCategory = vanTypeCategory;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}



	public String getVehicleRegistration() {
		return vehicleRegistration;
	}






	public void setVehicleRegistration(String vehicleRegistration) {
		this.vehicleRegistration = vehicleRegistration;
	}






	public String getVehicleType() {
		return vehicleType;
	}






	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}






	public int getTotalSeats() {
		return totalSeats;
	}






	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}


	public VanType getCategory() {
		return category;
	}


	public void setCategory(VanType category) {
		this.category = category;
	}


	public int getFlagged() {
		return flagged;
	}


	public void setFlagged(int flagged) {
		this.flagged = flagged;
	}


	@Override
	public String toString() {
		return "Van [id=" + id + ", vehicleRegistration=" + vehicleRegistration + ", vehicleType=" + vehicleType
				+ ", totalSeats=" + totalSeats + ", category=" + category + ", flagged=" + flagged + "]";
	}








	





	
	
	
	
}
