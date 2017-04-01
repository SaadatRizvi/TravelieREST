package com.travelie.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="customer")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonView(JSONViews.PrimaryView.class)
	private Integer id;
	
	@Column(name="first_name")
	@JsonView(JSONViews.CustomerView.class)
	private String firstName;
	
	@Column(name="last_name")
	@JsonView(JSONViews.CustomerView.class)
	private String lastName;
	
	@Column(name="email")
	@JsonView(JSONViews.CustomerView.class)
	private String email;
	
	@Column(name="username")
	@JsonView(JSONViews.CustomerView.class)
	private String username;
	
	@Column(name="password")
	@JsonView(JSONViews.CustomerView.class)
	private String password;
	
	@Column(name="regnumber")
	@JsonView(JSONViews.CustomerView.class)
	private int regNumber;
	
	@Column(name="phonenumber")
	@JsonView(JSONViews.CustomerView.class)
	private int phoneNumber;
	
	@Column(name="flagged")
	@JsonView(JSONViews.CustomerView.class)
	private int flagged;
	
	
	//Ticket.java   reference
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
		
	@JsonView(JSONViews.CustomerView.class)
	private Set<Ticket> tickets;
	
		 
		 
		 
		 
		// @JsonIgnore 
	//	 @JsonBackReference
		 public Set<Ticket> getTickets() {
			return tickets;
		}


		public void setTickets(Set<Ticket> tickets) {
			this.tickets = tickets;
		}


	public Customer(){
		
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getRegNumber() {
		return regNumber;
	}


	public void setRegNumber(int regNumber) {
		this.regNumber = regNumber;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", regNumber=" + regNumber + ", phoneNumber=" + phoneNumber + ", flagged=" + flagged + "]";
	}





	
	
	
	
}
