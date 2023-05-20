package com.kunjproject.newspringbootproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kunjproject.newspringbootproject.Dto.SignUpDto;
import com.kunjproject.newspringbootproject.dao.SignUpRepository;
import com.kunjproject.newspringbootproject.entities.SignUp;
@Service

public class SignUpService  implements SignUpServiceIMP{
@Autowired
SignUpRepository signRepo;


@Override
	public String save(SignUpDto sdto) {
		// TODO Auto-generated method stub
	int check= signRepo.EmailDuplicate(sdto.getEmailId());
	if (check >0 ) {
		return "EMAIL ID ALREDY EXIST";

	} else {
		SignUp s=new SignUp();
		s.setId(sdto.getId());
		s.setUserName(sdto.getUserName());
		s.setEmailId(sdto.getEmailId());
		s.setPassword(sdto.getPassword());
		
		signRepo.save(s);
		return "saved";
	}

}
}
