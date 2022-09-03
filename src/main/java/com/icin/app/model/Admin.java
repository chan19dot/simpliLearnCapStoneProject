package com.icin.app.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="admindetails")
public class Admin {
	private String employeename;
	private String userName;
	@Id
	private int adminid;
	private String password;
	
	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin() {
		super();
	}

	public Admin(String employeename, String userName, String password) {
		this.employeename= employeename;
		this.userName = userName;
		this.password = password;
	}
	
	public Admin(String userName, String password) {
		this.userName=userName;
		this.password=password;
	}
	
	
}
