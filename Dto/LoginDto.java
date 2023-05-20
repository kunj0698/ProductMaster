package com.kunjproject.newspringbootproject.Dto;

public class LoginDto {
	
	
	String Email;
	String Password;
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public LoginDto(String email, String password) {
		super();
		Email = email;
		Password = password;
	}
	
	
	

}
