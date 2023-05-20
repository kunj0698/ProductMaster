package com.kunjproject.newspringbootproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LogIn {
	@Id
	String Email;
	
	String Password;

	public LogIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogIn(String email, String password) {
		super();
		Email = email;
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "LogIn [Email=" + Email + ", Password=" + Password + "]";
	}
	
	

}
