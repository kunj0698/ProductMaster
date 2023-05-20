package com.kunjproject.newspringbootproject.Dto;

public class SignUpDto {
	
	private int Id;
	private String UserName;
	private  String EmailId;
	private  String Password;
	
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

	public SignUpDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignUpDto(int id, String userName, String emailId, String password) {
		super();
		Id = id;
		UserName = userName;
		EmailId = emailId;
		Password = password;
	}
	
	

}
