package com.weather.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weather.project.entity.Admin;
import com.weather.project.entity.User;
import com.weather.project.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userservice;

	
	@GetMapping("/home")
	public String getHomePage() {
		return "home";
	}
	
	@PostMapping("/loginpage")
	public String loginPost(@RequestParam String email, @RequestParam String password, HttpSession session) {
		try {
			User user = userservice.getUserByEmail(email);
			Admin admin = userservice.getAdminByEmail(email);
			if(admin != null) {
				if(userservice.validateForAdmin(admin, password)) {
					session.setAttribute("user", admin);
					return "redirect:admindash";
				}else {
					return "home";
				}
			}else {
				if(userservice.validateForUser(user, password)) {
					session.setAttribute("user", user);
					return "redirect:userdash";
				}else {
					return "home";
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "home";
	}
	
}
