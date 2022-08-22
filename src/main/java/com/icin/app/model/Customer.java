package com.icin.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {
	
	@Id
	private int id;
	
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String phoneNumber;
	private boolean access;
	private boolean blockStatus;
	private boolean chequeBookRequest;
	private double savingsAmount;
	private double primaryAmount;
	
	public Customer(String firstName, String lastName, String phonenumber, String email,String userName, String password, double savingsAmount, double primaryAmount) {
		this.firstName = firstName;
		this.email = email;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.phoneNumber =phonenumber;
		this.savingsAmount = savingsAmount;
		this.primaryAmount = primaryAmount;
		this.access =false;
		this.blockStatus = false;
		this.chequeBookRequest=false;
	}
	
}
