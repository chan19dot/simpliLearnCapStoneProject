package com.icin.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.app.model.Admin;
import com.icin.app.model.Customer;

@Service
public class AdminDAO{
	
	@Autowired
	AdminRepository adminRepository;
	
	public List<Admin> findByUserName(String name) {
		return adminRepository.findAdminByUsername(name) ;
	}
	
	public Admin findByemployeeName() {
		return null;
	}
	
	
	public List<Admin> findAll(){
		return adminRepository.findAll();
	}
	
	public boolean checkLogin(Admin admin) {
		List<Admin> l =findByUserName(admin.getUserName());
		for(Admin a : l) {
		if(a.getPassword().equals(admin.getPassword())) {
			return true;
		}
		}
		return false;
	}
	
	
}
