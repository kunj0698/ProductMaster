package com.kunjproject.newspringbootproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kunjproject.newspringbootproject.entities.SignUp;

@Repository
public interface SignUpRepository extends JpaRepository<SignUp, Integer> {
	 @Query(value=" Select count(1)  from products.sign_up where email_id=:emailId",  nativeQuery = true)
	
   public int  EmailDuplicate(@Param("emailId") String EmailId );
}
