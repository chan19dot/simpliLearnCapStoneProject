package com.icin.app.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.icin.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("select customer from customerdetails where customer.name=?1")
	public Customer findByName(String name);

}
