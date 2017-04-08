package com.travelie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.travelie.JSON.JSONViews;

@Entity
@Table(name="adminlogin")
public class AdminLogin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@JsonView(JSONViews.PrimaryView.class)
	private Integer id;
	
	@Column(name="user_name")
	@JsonView(JSONViews.AdminLoginView.class)
	private String userName;
	
	@Column(name="password")
	@JsonView(JSONViews.AdminLoginView.class)
	private String password;
	
	
	public AdminLogin(){
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "AdminLogin [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}


		
}
