package com.icin.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.app.model.Admin;

@Service
public class AdminDAO{
	
	@Autowired
	AdminRepository adminRepository;
	
	public Admin findByUserName(String name) {
		return null;
	}

}
