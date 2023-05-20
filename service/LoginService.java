package com.kunjproject.newspringbootproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kunjproject.newspringbootproject.Dto.LoginDto;
import com.kunjproject.newspringbootproject.dao.LoginRepository;
import com.kunjproject.newspringbootproject.entities.LogIn;

@Service
public class LoginService implements LoginServiceIMP {

	@Autowired
	LoginRepository logRepo;
	
	@Override
	public String save(LoginDto logDto) {
		// TODO Auto-generated method stub
		int check = logRepo.match(logDto.getEmail(),logDto.getPassword());
		if(check==1) {
		
		LogIn l=new LogIn();
		
		//l.setId(logDto.getId());
		l.setEmail(logDto.getEmail());
		l.setPassword(logDto.getPassword());
		
		logRepo.save(l);
		return "LOGEIN SUCCESSFULLY";
	}else {
		return "USER DOES NOT EXIST";
		
	}
	}
}
