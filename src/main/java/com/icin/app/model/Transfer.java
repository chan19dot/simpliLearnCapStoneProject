package com.icin.app.model;

import org.springframework.stereotype.Component;

@Component
public class Transfer{
	private int CustomerId;
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	private double beneficiaryId;
	private String beneficiaryName;
	
	private double amount;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Transfer(int customerId, double beneficiaryId, String beneficiaryName, Boolean transactionStatus, double amount) {
		super();
		CustomerId = customerId;
		this.beneficiaryId = beneficiaryId;
		this.beneficiaryName = beneficiaryName;
		this.amount = amount;
	}
	
	public double getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(double beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	
	
	public Transfer(double beneficiaryId, String beneficiaryName ) {
		super();
		this.beneficiaryId = beneficiaryId;
		this.beneficiaryName = beneficiaryName;
		

	}
	
	public Transfer() {
		super();
	}
	public Transfer(int customerId, double beneficiaryId, String beneficiaryName,
			 double amount) {
		super();
		this.CustomerId = customerId;
		this.beneficiaryId = beneficiaryId;
		this.beneficiaryName = beneficiaryName;
		this.amount = amount;
	}
	
}
