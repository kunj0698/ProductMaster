package com.kunjproject.newspringbootproject.entities;




import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductMaster  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int ProductId;
	private int Active;
	private String ProductName;
	private int CategoryName;
	private int SubCategoryName;
	private String Discription;
	private int Price;
    private String ManufactureDate;
	private int ProductSerialNo;
	private String WarrantyAndSupport;
	private String ImageUpload;
	private String ProductCondition;
	private String ProductColour;
	private String Discount;
	private String DateFrom;
    private String DateTo;
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public int getActive() {
		return Active;
	}
	public void setActive(int active) {
		Active = active;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(int categoryName) {
		CategoryName = categoryName;
	}
	public int getSubCategoryName() {
		return SubCategoryName;
	}
	public void setSubCategoryName(int subCategoryName) {
		SubCategoryName = subCategoryName;
	}
	public String getDiscription() {
		return Discription;
	}
	public void setDiscription(String discription) {
		Discription = discription;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getManufactureDate() {
		return ManufactureDate;
	}
	public void setManufactureDate(String manufactureDate) {
		ManufactureDate = manufactureDate;
	}
	public int getProductSerialNo() {
		return ProductSerialNo;
	}
	public void setProductSerialNo(int productSerialNo) {
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
	public ProductMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductMaster(int productId, int active, String productName, int categoryName, int subCategoryName,
			String discription, int price, String manufactureDate, int productSerialNo, String warrantyAndSupport,
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
	@Override
	public String toString() {
		return "ProductMaster [ProductId=" + ProductId + ", Active=" + Active + ", ProductName=" + ProductName
				+ ", CategoryName=" + CategoryName + ", SubCategoryName=" + SubCategoryName + ", Discription="
				+ Discription + ", Price=" + Price + ", ManufactureDate=" + ManufactureDate + ", ProductSerialNo="
				+ ProductSerialNo + ", WarrantyAndSupport=" + WarrantyAndSupport + ", ImageUpload=" + ImageUpload
				+ ", ProductCondition=" + ProductCondition + ", ProductColour=" + ProductColour + ", Discount="
				+ Discount + ", DateFrom=" + DateFrom + ", DateTo=" + DateTo + "]";
	}
	
       

}
