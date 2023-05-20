package com.kunjproject.newspringbootproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kunjproject.newspringbootproject.Dto.Dto;
import com.kunjproject.newspringbootproject.dao.UserRepository;
import com.kunjproject.newspringbootproject.entities.User;

import jakarta.persistence.Embeddable;
import jakarta.transaction.Transactional;

@Service

public class ProductService implements ProductServiceIMP {

	private static final String String = null;
	@Autowired
	UserRepository userRepo;
//	@Override
//	 public String addProduct(Dto dt) {
//	
//		User user= new User();
//		
//		
//		user.setActive(dt.getActive());
//		user.setCategoryId(dt.getCategoryId());
//		user.setCategoryName(dt.getCategoryName());
//		user.setDiscription(dt.getDiscription());
//		
//		userRepo.save(user);
//			return "saved";
//
//}

	// @Override

	/*
	 * List<User> user= userRepo.findAll(); List<Dto> cDto= new ArrayList<>();
	 * for(User u: user) {
	 * 
	 * Dto dto = new Dto( u.getCategoryId(), u.getActive(), u.getCategoryName(),
	 * u.getDiscription() ); cDto.add(dto); }
	 * 
	 * 
	 * return cDto;
	 */
	// System.out.println(cDto);

	// }

	@Override
	public Optional<User> ById(int categoryId) {
		// TODO Auto-generated method stub
		return userRepo.findById(categoryId);

	}

//
//	@Override
//	 public String addProduct(Dto dt) {
//int user =dt.getCategoryId();
//		//User user= new User();
//		if(user != null) {
//		  	 user.get().setActive(dt.getActive());
//	     	 user.get().setCategoryId(dt.getCategoryId());
//		    user.get().setCategoryName(dt.getCategoryName());
//			user.get().setDiscription(dt.getDiscription());
//		 
//		userRepo.save(user.get());
//		return "update";
//		  }
//		else {
//			  
//			 User use=new User();
//			    
//			    use.setActive(dt.getActive());
//			    use.setCategoryId(dt.getCategoryId());  
//			    use.setCategoryName(dt.getCategoryName());
//				use.setDiscription(dt.getDiscription());
//				//user.setDiscription(dt.getDiscription());
//				System.err.println(dt.getCategoryName());
//				userRepo.save(use);
//  return  "saved";
//		  }
//		
//			}

	@Override
	public String addProduct(Dto dt) {

	//	User us = new User();
	/*
	 * us = userRepo.findById(dt.getCategoryId()).get(); System.out.println(us);
	 */
		int count = userRepo.checkDuplicate(dt.getCategoryName().toLowerCase(),String.valueOf(dt.getCategoryId()));
		System.out.println(count);
		
			if (count>0 ) {
				return "DATA ALREDY EXIST";

			} else {
				User user = new User();

				System.out.println(dt);
				user.setActive(dt.getActive());
				user.setCategoryId(dt.getCategoryId());
				user.setCategoryName(dt.getCategoryName());
				user.setDiscription(dt.getDiscription());

				userRepo.save(user);
				return "DATA SAVED";
			}
		}
		
//delete
	
	@Override
	
	public String delById(int categoryId) {

		// TODO Auto-generated method stub
		User user = new User();
		Optional<User> userid = userRepo.findById(categoryId);
		System.out.println("id " + categoryId);
		user = userid.get();
		System.out.println("usser"+user);
		user.setActive(9);
    	userRepo.save(user);
       return "deleted";
	}

//all list
	@Override
	public List<User> ListAll() {
		// TODO Auto-generated method stub

		List<User> list = userRepo.ListAll();
		{

			list.forEach(e -> {
			});
			return list;
		}

	}
}
