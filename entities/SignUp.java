package com.kunjproject.newspringbootproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class SignUp {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int Id;
	private String UserName;
	private  String EmailId;
	private  String Password;
	
	public SignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignUp(int id, String userName, String emailId, String password) {
		super();
		Id = id;
		UserName = userName;
		EmailId = emailId;
		Password = password;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "SignUp [Id=" + Id + ", UserName=" + UserName + ", EmailId=" + EmailId + ", Password=" + Password + "]";
	} 
	
	

}
