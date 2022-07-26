package com.example.SalesIncentiveBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@Column(unique=true)
	private String email;
	private String password;
	private String role = "admin";
	
	public Admin()
	{
		
	}
	
	public Admin(String email, String password, String role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return "email=" + email + ", password=" + password + ", role=" + role + "]";
	}	
	
	
	

	
	
}