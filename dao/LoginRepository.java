package com.kunjproject.newspringbootproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kunjproject.newspringbootproject.entities.LogIn;

public interface LoginRepository  extends JpaRepository<LogIn, Integer>{
	
@Query(value="Select count(1) from products.sign_up where sign_up.email_id=:email and sign_up.password=:password", nativeQuery= true)

public int  match(@Param("email") String Email,@Param("password") String Password );

}
