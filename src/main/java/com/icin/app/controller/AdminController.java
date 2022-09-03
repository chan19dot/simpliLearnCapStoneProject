package com.icin.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icin.app.model.Admin;
import com.icin.app.model.Customer;
import com.icin.app.model.Security;
import com.icin.app.model.Transaction;
import com.icin.app.model.Transfer;
import com.icin.app.service.AdminDAO;
import com.icin.app.service.AdminRepository;
import com.icin.app.service.CustomerDAO;
import com.icin.app.service.CustomerRepository;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class AdminController {
	
	@Autowired
	CustomerDAO customerRepo;
	
	@Autowired
	AdminDAO adminRepo;
	
	@Autowired
	Security loginCheck;
	
	@GetMapping("/")
	public String mainPage() {
		return "Hello";
	}
	
	@PostMapping("/Registration")
	public String Registration(@RequestParam String Userid, @RequestParam String password ) {
		System.out.println(Userid+"\n" +password);
		//call update from here
		
		return "Registration";
	}
	
	@GetMapping("/Admin/blockuser")
	public String Block(@RequestParam int id) {
		return "block";
	}
	
	@PostMapping("/login")
	public ResponseEntity<Security> Login(@RequestBody Admin admin ) {
		if(adminRepo.checkLogin(admin)) {
			loginCheck.setLogin(true);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(loginCheck);
		}
		loginCheck.setLogin(false);
		return ResponseEntity.status(HttpStatus.OK).body(loginCheck);
	}
	
	
	@PostMapping("/AuthorizeCheque")
	public ResponseEntity<Customer> AuthorizeCheque(@RequestBody Customer customer) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerRepo.authorizeChequeRequest(customer.getId()));
				
	}
	
	@PostMapping("/customerSignUp")
	public Customer customerSignUp(@RequestBody Customer customer ) {
		return customerRepo.save(customer);
	}
	
	@GetMapping("/findAllAdmins")
	public List<Admin> findAllAdmins() {
		return adminRepo.findAll();
	}
	
	@GetMapping("/AllCustomersWithNoAccess")
	public List<Customer> findAllCustomersWithNoAccess(){
		return customerRepo.findAllWithNoAccess();
	}
	
	@GetMapping("/AllCustomers")
	public List<Customer> findAllCustomers(){
		return customerRepo.findAll();
	}
	
	@PostMapping("/blockCustomer")
	public Customer block(@RequestBody Customer customer) {
		customer.setBlockStatus(true);
		return customerRepo.update(customer);
	}
	@GetMapping("/getCustomerById")
	public Customer getCustomerById(@RequestParam int id) {
		if(customerRepo.findById(id).isPresent()) {
			return customerRepo.findById(id).get();
		}
		return null;
	}
	@PostMapping("/customerLogin")
	public Security customerLogin(@RequestBody Customer customer) {
		return customerRepo.LoginCheck(customer);
	}
	
	@PostMapping("/requestChequeBook")
	public Customer customerChequeRequest(@RequestParam int id) {
		return customerRepo.chequeRequest(id);
	}
	
	@PostMapping("/Transfer")
	public Transfer customerChequeRequest(@RequestBody Transfer transfer) {
		return customerRepo.transferRequest(transfer) ;
	}
	
	@PostMapping("/transaction")
	public Customer customerDeposit(@RequestBody Transaction transaction) {
		return customerRepo.transactionService(transaction);
	}
	
	@PostMapping("/AuthorizeAccess")
	public ResponseEntity<Customer> giveAccess(@RequestBody Customer customer){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerRepo.giveAccess(customer.getId()));
	}
	
	@GetMapping("/testTransfer")
	public Transfer test() {
		Transfer transaction = new Transfer();
		transaction.setAmount(2000);
		transaction.setCustomerId(1);
		transaction.setBeneficiaryId(1213141516);
		return transaction;
	}
	
	
	
}
