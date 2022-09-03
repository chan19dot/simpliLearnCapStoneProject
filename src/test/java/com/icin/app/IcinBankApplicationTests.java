package com.icin.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.icin.app.model.Customer;
import com.icin.app.service.AdminDAO;
import com.icin.app.service.CustomerDAO;

@SpringBootTest
@TestPropertySource(locations= "classpath:application-test.properties")
class IcinBankApplicationTests {
	
	@Autowired
	AdminDAO adminRepo;
	
	@Autowired
	CustomerDAO customerRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	void SaveToCustomerDb() {
		Customer actual = new Customer("firstName","lastName","1214151618","email@email","test","test",1500,1200,1122334455);
		customerRepo.save(actual);
		Optional<Customer> expected = customerRepo.findById(1);
		assertThat(expected.get().equals(actual));
		
	}
	@Test
	void giveAccess() {
		customerRepo.giveAccess(1);
		Optional<Customer> expected = customerRepo.findById(1);
		assertThat(expected.get().isAccess()==true);
		
	}
	@Test
	void RequestCheque() {
		customerRepo.chequeRequest(1);
		Optional<Customer> expected = customerRepo.findById(1);
		assertThat(expected.get().isChequeBookRequest()==true);
		
	}
	@Test
	void IssueChequeReuest() {
		customerRepo.authorizeChequeRequest(1);
		Optional<Customer> expected = customerRepo.findById(1);
		assertThat(expected.get().isChequeBookRequest()==false);;
		
	}
	
}
