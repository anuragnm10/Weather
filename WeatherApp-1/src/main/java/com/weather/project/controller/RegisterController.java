package com.weather.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weather.project.entity.Admin;
import com.weather.project.entity.User;
import com.weather.project.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userservice;

	@GetMapping("/register")
	public String getRegisterPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(User user, Admin admin, @RequestParam("type") String type) {
		if(type.equals("user")) {
			try {
				userservice.insertUser(user);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}else if(type.equals("admin")) {
			try {
				userservice.insertAdmin(admin);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return "redirect:/home";
	}
}
