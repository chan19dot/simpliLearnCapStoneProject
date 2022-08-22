package com.icin.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.icin.app.model.Customer;

@Service
public class CustomerDAO {
	
	@Autowired
	CustomerRepository customerRepo;
	
}
