package com.kunjproject.newspringbootproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kunjproject.newspringbootproject.entities.SubCategoryProduct;
import com.kunjproject.newspringbootproject.entities.User;

public interface SubUserRepository extends JpaRepository<SubCategoryProduct,Integer>{

	void save(Optional<SubCategoryProduct>subid);


	//@Query(value = "SELECT * FROM products.sub_category_product WHERE ACTIVE!=9", nativeQuery = true)

	  @Query
	  (value="SELECT user.category_name,sub_category_product.active,sub_category_product.discription,sub_category_product.sub_category_id,"
	  		+ "sub_category_product.sub_category_name FROM user JOIN sub_category_product  WHERE  sub_category_product.active!=9 "
	  +
	  "and sub_category_product.category_name = user.category_id and sub_category_product.category_name"
	 , nativeQuery = true ) List<SubCategoryProduct> loadAll();
	 


	 @Query(value="SELECT  count(1) from products.sub_category_product where active!=9 and lower(sub_category_name)= :subCategoryName AND sub_category_id!=:subCategoryId ",  nativeQuery = true)
	  
	  public int checkDuplicate(@Param("subCategoryName") String SubCategoryName, @Param("subCategoryId") String SubCategoryId );

	 
	 @Query(value="Select category_id,category_name from user where active!=9",nativeQuery=true)
     List<Object[]> subDrop();

	
}
