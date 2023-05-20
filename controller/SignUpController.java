package com.kunjproject.newspringbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kunjproject.newspringbootproject.Dto.SignUpDto;
import com.kunjproject.newspringbootproject.service.SignUpService;
import com.kunjproject.newspringbootproject.service.SignUpServiceIMP;

@Controller
public class SignUpController {
	
	
	  @Autowired SignUpService signUpService ;
	 
	
	@RequestMapping("/sign")
	public String SignUpPage(){
		return "signup";
	}
	
	@ResponseBody
	@PostMapping("/signup")
	public String save(@ModelAttribute SignUpDto Sdto) {
		String data= signUpService.save(Sdto);
		return data;
	}
	
	
	

}
