package com.icin.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.icin.app.model.Customer;
import com.icin.app.model.Security;
import com.icin.app.model.Transaction;
import com.icin.app.model.Transfer;

@Service
public class CustomerDAO {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	Security security;
	
	public Customer save(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public List<Customer> findAll(){
		return customerRepo.findAll();
	}
	
	public List<Customer> findAllWithNoAccess(){
		return customerRepo.findAllWithNoAccess();
	}
	
	public Customer update(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public Optional<Customer> findById(int id) {
		return customerRepo.findById(id);
	}
	
	public Security LoginCheck(Customer customer) {
		Customer customerFullObj = customerRepo.findByUserName(customer.getUserName());
		System.out.println(customerFullObj.toString());
		if(customerFullObj.isAccess()&& !customerFullObj.isBlockStatus() && customerFullObj.getpasword().equals(customer.getpasword())) {
			security.setLogin(true);
			security.setId(customerFullObj.getId());
			return security;
		}
		security.setLogin(false);
		return security;
	}
	
	public Customer chequeRequest(int id) {
		Optional<Customer> customerFullObj = customerRepo.findById(id);
		if(customerFullObj.isPresent()) {
			customerFullObj.get().setChequeBookRequest(true);
			return customerRepo.save(customerFullObj.get());
		}
		return null;
	}
	
	public Customer authorizeChequeRequest(int id) {
		Optional<Customer> customerFullObj = customerRepo.findById(id);
		if(customerFullObj.isPresent()) {
			customerFullObj.get().setChequeBookRequest(false);
			return customerRepo.save(customerFullObj.get());
		}
		return null;
	}
	
	public Transfer transferRequest(Transfer transfer){
		Optional<Customer> customerObj = customerRepo.findById(transfer.getCustomerId());
		Customer benificiary = customerRepo.findByAccountNumber(transfer.getBeneficiaryId());
		if(customerObj.isPresent()) {
		 	customerObj.get().setPrimaryAmount(customerObj.get().getPrimaryAmount()- transfer.getAmount());
		 	customerRepo.save(customerObj.get());
		}
		benificiary.setPrimaryAmount(benificiary.getPrimaryAmount()+transfer.getAmount());
		customerRepo.save(benificiary);
		return transfer;
	}
	
	public Customer transactionService(Transaction transaction) {
		Optional<Customer> customerObj = customerRepo.findById(transaction.getCustomerId());
		if(customerObj.isPresent()) {
			if(transaction.getIsDeposit()) {
				customerObj.get().setPrimaryAmount(customerObj.get().getPrimaryAmount()+transaction.getAmount());
			}
			else {
				customerObj.get().setPrimaryAmount(customerObj.get().getPrimaryAmount()-transaction.getAmount());
			}
		}
		return customerRepo.save(customerObj.get());
	}
	
	public Customer giveAccess(int id) {
		Optional<Customer> customerObj = customerRepo.findById(id);
		if(customerObj.isPresent()) {
			customerObj.get().setAccess(true);
			
		}
		return customerRepo.save(customerObj.get());
	}
	
	
}
