package com.kunjproject.newspringbootproject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.kunjproject.newspringbootproject.dao.UserRepository;
import com.kunjproject.newspringbootproject.entities.User;



@SpringBootApplication

public class NewspringbootprojectApplication {

	public static void main(String[] args) { 
		SpringApplication.run(NewspringbootprojectApplication.class, args);
		
		
//		ApplicationContext context = SpringApplication.run(NewspringbootprojectApplication.class, args);
//                       UserRepository userRepository =  context.getBean(UserRepository.class);
//                       
//                       User user =new User();
//                       user.setCategoryName("Book");
//                       user.setDiscription("black bag");
//                       
//                     User user1 = userRepository.save(user);
//                       
//                     System.out.println(user1);
	}

}
