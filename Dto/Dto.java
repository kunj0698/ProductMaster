package com.kunjproject.newspringbootproject.Dto;

public class Dto {
	private int CategoryId;
	private int Active;
	private String CategoryName;
	private String Discription;
	
	public Dto() {
		super();
	}

	public Dto(int categoryId, int active, String categoryName, String discription) {
		super();
		CategoryId = categoryId;
		Active = active;
		CategoryName = categoryName;
		Discription = discription;
	}
	
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

	@Override
	public String toString() {
		return "Dto [CategoryId=" + CategoryId + ", Active=" + Active + ", CategoryName=" + CategoryName
				+ ", Discription=" + Discription + "]";
	}

	
	
	
	
	
	}
	


