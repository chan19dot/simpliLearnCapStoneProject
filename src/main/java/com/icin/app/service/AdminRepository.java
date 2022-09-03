package com.icin.app.service;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icin.app.model.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	
//	@Query("select admin from Admin admin where admin.employeename=?1")
//	public Admin findAdmin(String name);
	
//	@Query(value="select * from admindetails where admindetails.employeename=?1", nativeQuery=true)
	public List<Admin> findAdminByEmployeename(String employeename);
	
	@Query("select admin from Admin admin where admin.adminid=?1")
	public Admin findAdminById(int id);
	
	@Query(value="select * from admindetails a where a.user_name = ?1", nativeQuery=true)
	public List<Admin> findAdminByUsername(String userName);
	
	
}
