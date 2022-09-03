package com.icin.app.model;

import org.springframework.stereotype.Component;

@Component
public class Security {
	boolean login;
	
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public Security() {
		super();
	}

	public Security(boolean login) {
		super();
		this.login = login;
	}
	
	public Security(boolean login, int id) {
		this.login= login;
		this.id = id;
	}
	
}
