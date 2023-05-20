package com.kunjproject.newspringbootproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kunjproject.newspringbootproject.entities.ProductMaster;
import com.kunjproject.newspringbootproject.entities.SubCategoryProduct;

@Repository

public interface ProductRepository  extends JpaRepository<ProductMaster,Integer>{
	
	
	/*
	 * @Query(
	 * value="SELECT user.category_name,product_master.active,product_master.image_upload,product_master.product_id,product_master.product_name,product_master.discription,product_master.price,\r\n"
	 * +
	 * "product_master.discount FROM user JOIN product_master  WHERE  product_master.active!=9 \r\n"
	 * +
	 * "and product_master.category_name = user.category_id and product_master.category_name"
	 * , nativeQuery = true ) List<ProductMaster> loadTable1();
	 */
	
	
	
	  @Query(
	  value="SELECT user.category_name,product_master.active,product_master.image_upload,product_master.product_id,product_master.product_name,\r\n"
	  +
	  "product_master.discription,product_master.price,product_master.discount,product_master.date_from,product_master.date_to,product_master.manufacture_date,\r\n"
	  +
	  "product_master.product_colour,product_master.product_condition,product_master.product_serial_no,product_master.sub_category_name,\r\n"
	  +
	  "product_master.warranty_and_support  FROM user JOIN product_master  WHERE  product_master.active!=9 \r\n"
	  +
	  "and product_master.category_name = user.category_id"
	  , nativeQuery = true )
	 
	 
	// @Query(value="Select * from product_master where active!=9",nativeQuery=true)
	  List<Object[]> loadTable1(); 

	  
	 @Query(value="SELECT  count(1) from products.product_master where active!=9 and lower(product_name)= :productName AND product_id!= :productId ",  nativeQuery = true)

	 public int checkDuplicate(@Param("productName") String ProductName, @Param("productId") String ProductId );
	 
	 @Query(value="SELECT sub_category_product.sub_category_id,sub_category_product.sub_category_name from \r\n"
	 		+ "sub_category_product where sub_category_product.category_name=:categoryId", nativeQuery = true)
	 List<Object[]>drop(int categoryId);
	 
	 
	 @Query(value="Select category_id,category_name from user where active!=9",nativeQuery=true)
	 List<Object[]>catDrop();
	 
}
