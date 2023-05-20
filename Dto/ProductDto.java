package com.kunjproject.newspringbootproject.Dto;

import java.util.Date;

public class ProductDto {
	
	private  int ProductId;
	private  String Active;
	private  String ProductName;
    private  String CategoryName;
    private  String SubCategoryName;
	private  String Discription;
	private  String Price;
	
	private  String ManufactureDate;
	private  String ProductSerialNo;
	private  String WarrantyAndSupport;
	private String ImageUpload;
	private String ProductCondition;
	private String ProductColour;
	private String Discount;
	private  String DateFrom;
	private  String DateTo;
	public ProductDto() {
		super();
	}
	public ProductDto(int productId, String active, String productName, String categoryName, String subCategoryName,
			String discription, String price, String manufactureDate, String productSerialNo, String warrantyAndSupport,
			String imageUpload, String productCondition, String productColour, String discount, String dateFrom,
			String dateTo) {
		super();
		ProductId = productId;
		Active = active;
		ProductName = productName;
		CategoryName = categoryName;
		SubCategoryName = subCategoryName;
		Discription = discription;
		Price = price;
		ManufactureDate = manufactureDate;
		ProductSerialNo = productSerialNo;
		WarrantyAndSupport = warrantyAndSupport;
		ImageUpload = imageUpload;
		ProductCondition = productCondition;
		ProductColour = productColour;
		Discount = discount;
		DateFrom = dateFrom;
		DateTo = dateTo;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String active) {
		Active = active;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
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
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getManufactureDate() {
		return ManufactureDate;
	}
	public void setManufactureDate(String manufactureDate) {
		ManufactureDate = manufactureDate;
	}
	public String getProductSerialNo() {
		return ProductSerialNo;
	}
	public void setProductSerialNo(String productSerialNo) {
		ProductSerialNo = productSerialNo;
	}
	public String getWarrantyAndSupport() {
		return WarrantyAndSupport;
	}
	public void setWarrantyAndSupport(String warrantyAndSupport) {
		WarrantyAndSupport = warrantyAndSupport;
	}
	public String getImageUpload() {
		return ImageUpload;
	}
	public void setImageUpload(String imageUpload) {
		ImageUpload = imageUpload;
	}
	public String getProductCondition() {
		return ProductCondition;
	}
	public void setProductCondition(String productCondition) {
		ProductCondition = productCondition;
	}
	public String getProductColour() {
		return ProductColour;
	}
	public void setProductColour(String productColour) {
		ProductColour = productColour;
	}
	public String getDiscount() {
		return Discount;
	}
	public void setDiscount(String discount) {
		Discount = discount;
	}
	public String getDateFrom() {
		return DateFrom;
	}
	public void setDateFrom(String dateFrom) {
		DateFrom = dateFrom;
	}
	public String getDateTo() {
		return DateTo;
	}
	public void setDateTo(String dateTo) {
		DateTo = dateTo;
	}
	
	
	
}