package com.tic.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tic.app.service.UserService;

@Controller
public class UserRegController {
	private final UserService userService;
		
	@Autowired
	public UserRegController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerGET() throws Exception {
		return "/resister";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPOST() throws Exception {
		//TODO BCrypt를 이용한 PW 암호화.
		return "redirect:/login";
	}
}
