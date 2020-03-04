package com.prabin.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prabin.springproject.dao.UserDao;
import com.prabin.springproject.model.User;

@Controller
public class SignupController {
	
	@Autowired
	private UserDao  udao;
	
	
	@RequestMapping(value="/signup", method=RequestMethod.GET )
	public String getSignUpForm(){
		
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute User user){
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		
		udao.addUser(user);
		
		return "login";
	}
	

}
