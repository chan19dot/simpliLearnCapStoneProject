package com.icin.app.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icin.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
