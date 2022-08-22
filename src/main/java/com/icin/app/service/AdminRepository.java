package com.icin.app.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icin.app.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	
	@Query("select admin from Admin admin where admin.name=?1")
	public Admin findAdmin(String name);
	
	@Query("select admin from Admin admin where admin.id=?1")
	public Admin findAdminById(int id);
	
	@Query("select admin from Admin admin where admin.userName=?1")
	public Admin findAdminByUsername(String userName);
	
}
