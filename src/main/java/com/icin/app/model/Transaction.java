package com.icin.app.model;

import org.springframework.stereotype.Component;

@Component
public class Transaction {
	private int customerId;
	private double amount;
	private Boolean isDeposit;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Boolean getIsDeposit() {
		return isDeposit;
	}
	public void setIsDeposit(Boolean isDeposit) {
		this.isDeposit = isDeposit;
	}
	public Transaction(int customerId, double amount, Boolean isDeposit) {
		super();
		this.customerId = customerId;
		this.amount = amount;
		this.isDeposit = isDeposit;
	}
	public Transaction() {
		super();
	}
	
	
}
