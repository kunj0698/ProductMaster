package com.kunjproject.newspringbootproject.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int CategoryId;
	private int Active;
	private  String CategoryName;
	private  String Discription; 

	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public int getActive() {
		return Active;
	}

	public void setActive(int active) {
		Active = active;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getDiscription() {
		return Discription;
	}

	public void setDiscription(String discription) {
		Discription = discription;
	}

	public User(int categoryId, int active, String categoryName, String discription) {
		super();
		CategoryId = categoryId;
		Active = active;
		CategoryName = categoryName;
		Discription = discription;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [CategoryId=" + CategoryId + ", Active=" + Active + ", CategoryName=" + CategoryName
				+ ", Discription=" + Discription + "]";
	}
	
	
	
	}
	
	
	


