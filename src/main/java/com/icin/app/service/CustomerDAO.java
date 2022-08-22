package com.icin.app.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.icin.app.model.Customer;

@Service
public class CustomerDAO {
	
	@Query("select customer from customerdetails where customer.name=?1")
	public Customer findByName(String name) {
	return null;
	}
	
}
