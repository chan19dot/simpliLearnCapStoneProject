package com.icin.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customerdetails")
public class Customer {
	
	@Id
	private int id;
	
	private String userName;
	
	
	private String firstName;
	
	
	private String lastName;
	
	
	private String pasword;
	
	
	private String email;
	
	
	private String phoneNumber;
	
	
	private boolean access;
	
	
	private boolean blockStatus;
	
	
	private boolean chequeBookRequest;
	
	
	private double savingsAmount;
	
	
	private double primaryAmount;
	
	
	private double accountNumber;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", pasword=" + pasword + ", email=" + email + ", phoneNumber=" + phoneNumber + ", access=" + access
				+ ", blockStatus=" + blockStatus + ", chequeBookRequest=" + chequeBookRequest + ", savingsAmount="
				+ savingsAmount + ", primaryAmount=" + primaryAmount + ", accountNumber=" + accountNumber + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getpasword() {
		return pasword;
	}

	public void setpasword(String pasword) {
		this.pasword = pasword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}

	public boolean isBlockStatus() {
		return blockStatus;
	}

	public void setBlockStatus(boolean blockStatus) {
		this.blockStatus = blockStatus;
	}

	public boolean isChequeBookRequest() {
		return chequeBookRequest;
	}

	public void setChequeBookRequest(boolean chequeBookRequest) {
		this.chequeBookRequest = chequeBookRequest;
	}

	public double getSavingsAmount() {
		return savingsAmount;
	}

	public void setSavingsAmount(double savingsAmount) {
		this.savingsAmount = savingsAmount;
	}

	public double getPrimaryAmount() {
		return primaryAmount;
	}

	public void setPrimaryAmount(double primaryAmount) {
		this.primaryAmount = primaryAmount;
	}

	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}
	

	public Customer(String userName, String pasword) {
		super();
		this.userName = userName;
		this.pasword = pasword;
	}

	public Customer(String firstName, String lastName, String phonenumber, String email,String userName, String pasword, double savingsAmount, double primaryAmount, double accountNumber) {
		this.firstName = firstName;
		this.email = email;
		this.lastName = lastName;
		this.userName = userName;
		this.pasword = pasword;
		this.phoneNumber =phonenumber;
		this.savingsAmount = savingsAmount;
		this.primaryAmount = primaryAmount;
		this.access =false;
		this.blockStatus = false;
		this.chequeBookRequest=false;
		this.accountNumber= accountNumber;
	}
	
}
