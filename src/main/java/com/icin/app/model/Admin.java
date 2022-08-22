package com.icin.app.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="adminDb")
public class Admin {
	private String name;
	private String userName;
	@Id
	private int id;
	private String password;
	
	public Admin(String name, String userName, String password) {
		this.name= name;
		this.userName = userName;
		this.password = password;
	}
	
	
}
