package com.kunjproject.newspringbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kunjproject.newspringbootproject.Dto.LoginDto;
import com.kunjproject.newspringbootproject.service.LoginService;

@Controller
public class LoginController {
	@Autowired LoginService log;
	
	@RequestMapping("/login")
	public String login() {
		return "index";
	}
	
	@ResponseBody
	@PostMapping("/enter")
	public String save(@ModelAttribute LoginDto logDto ) {
		String data= log.save(logDto);
		return data;
	}
	

}
