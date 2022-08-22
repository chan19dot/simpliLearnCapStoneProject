package com.icin.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	
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
	public String Block() {
		return "block";
	}
	
	@GetMapping("/login")
	public String Login() {
		return "login";
	}
	
	@GetMapping("/grantAccess")
	public String Access() {
		return "Access";
	}
	
	@GetMapping("/AuthorizeCheque")
	public String AuthorizeCheque() {
		return "Cheque";
	}
}
