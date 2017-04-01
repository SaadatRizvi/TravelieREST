package com.travelie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.travelie.JSON.JSONViews;

@Entity
@Table(name="ticket")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonView(JSONViews.PrimaryView.class)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="bookings_id")
	@JsonView(JSONViews.TicketView.class)
	private Booking booking;
	
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	@JsonView(JSONViews.TicketView.class)
	 Customer customer;
	
	@Column(name="seat_no")
	@JsonView(JSONViews.TicketView.class)
	private int seatNumber;
	
	
	
	public Ticket(){
		        
	}



	@Override
	public String toString() {
		return "Ticket [id=" + id + ", booking=" + booking + ", customer=" + customer + ", seatNumber=" + seatNumber
				+ "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Booking getBooking() {
		return booking;
	}



	public void setBooking(Booking booking) {
		this.booking = booking;
	}


	
	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public int getSeatNumber() {
		return seatNumber;
	}



	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}


	
	
}
