package com.kunjproject.newspringbootproject.Dto;

public class SubDto {

	private int SubCategoryId;
	private int Active;
	private  String CategoryName;
    private  String SubCategoryName;
	private  String Discription;
	
	public SubDto() {
		super();
	}
	
	public SubDto(int active, int subCategoryId, String categoryName, String subCategoryName, String discription) {
		super();
		Active = active;
		SubCategoryId = subCategoryId;
		CategoryName = categoryName;
		SubCategoryName = subCategoryName;
		Discription = discription;
	}



	public int getActive() {
		return Active;
	}

	public void setActive(int active) {
		Active = active;
	}

	public int getSubCategoryId() {
		return SubCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		SubCategoryId = subCategoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getSubCategoryName() {
		return SubCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		SubCategoryName = subCategoryName;
	}

	public String getDiscription() {
		return Discription;
	}

	public void setDiscription(String discription) {
		Discription = discription;
	}

	@Override
	public String toString() {
		return "SubDto [Active=" + Active + ", SubCategoryId=" + SubCategoryId + ", CategoryName=" + CategoryName
				+ ", SubCategoryName=" + SubCategoryName + ", Discription=" + Discription + "]";
	}
	
	

}
