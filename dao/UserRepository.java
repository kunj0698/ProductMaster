package com.kunjproject.newspringbootproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.kunjproject.newspringbootproject.Dto.Dto;
import com.kunjproject.newspringbootproject.entities.SubCategoryProduct;
import com.kunjproject.newspringbootproject.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	// void save(Optional<User> userid);

	@Query(value = "SELECT * FROM products.user WHERE ACTIVE!=9", nativeQuery = true)
	List<User> ListAll();

	
	  
	  @Query(value="SELECT  count(1) from products.user where active!=9 and lower(category_name)= :categoryName AND category_id!=:categoryId ",  nativeQuery = true)
	  
	  public int checkDuplicate(@Param("categoryName") String CategoryName, @Param("categoryId") String categoryId );



}
