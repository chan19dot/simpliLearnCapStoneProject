package com.icin.app.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.icin.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query(value="select * from customerdetails c where c.\"firstName\"=(?1)", nativeQuery=true)
	public Customer findByName(String name);
	
//	@Query(value="INSERT into ")
//	public Customer save(Customer customer);
	
	@Query(value="select * from customerdetails", nativeQuery=true)
	public List<Customer> findAll();
	
	@Query(value="select * from customerdetails c where c.access=false", nativeQuery=true)
	public List<Customer> findAllWithNoAccess();
	
	@Query(value="select * from customerdetails c where c.user_name=(?1)", nativeQuery=true)
	public Customer findByUserName(String userName);
	
	@Query(value="select * from customerdetails c where c.account_number= (?1)", nativeQuery= true)
	public Customer findByAccountNumber(double accountNumber);
}
