package com.kunjproject.newspringbootproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.kunjproject.newspringbootproject.Dto.Dto;
import com.kunjproject.newspringbootproject.entities.User;



public interface ProductServiceIMP {

   
    String addProduct(Dto dt);
    
   public  List<User> ListAll();
    
     Optional<User> ById(int categoryId);
     
     String delById(int categoryId);
}
