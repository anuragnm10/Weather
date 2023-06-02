package com.weather.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weather.project.dto.ForecastDTO;
import com.weather.project.dto.WeatherDTO;
import com.weather.project.entity.User;
import com.weather.project.service.UserService;
import com.weather.project.service.WeatherService;

@Controller
public class DashboardController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private WeatherService weatherservice;
	
	
	@GetMapping("/userdash")
	public String userDashPage() {
		return "userdashboard";
	}
	
	@GetMapping("/search")
	public String userDashSearch(Model model, @RequestParam ("query") String query, Map<String, List<WeatherDTO>> map, @RequestParam("category") String category) throws JsonProcessingException {
		List<WeatherDTO> list = new ArrayList<>();
		WeatherDTO weather = new WeatherDTO();
//		Map<String, String> errorMap = new HashMap<>();
		if(category.equals("weather")) {
			try {
				weather = weatherservice.weather(query);
			}catch(Exception e) {
				
				String errorMessage = "City "+query+" Not Found";
				System.out.println(errorMessage);
				model.addAttribute("error", errorMessage);
			}
		}else if(category.equals("forecast")) {
			try {
				List<ForecastDTO> forecast = weatherservice.forecast(query);
				model.addAttribute("sortedForecast", forecast);
				model.addAttribute("City", Character.toUpperCase(query.charAt(0))+query.substring(1));
			}catch(Exception e) {
				String errorMessage = "City "+query+" Not Found";
				System.out.println(errorMessage);
				model.addAttribute("error", errorMessage);
			}
		}
		list.add(weather);
		map.put("weather", list);
		
		return "userdashboard";
	}
	
	@GetMapping("/search/{query}")
	public String refresh(@PathVariable String query, RedirectAttributes redirectattributes) {
		String category = "weather";
		redirectattributes.addAttribute("query",query);
		redirectattributes.addAttribute("category",category);
		return "redirect:/search";
	}
	
	@GetMapping("/admindash")
	public String getUsers(Map<String, List<User>> map) {
		List<User> userlist = new ArrayList<>();
		try {
			userlist = userservice.getAllUsers();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		map.put("user", userlist);
		
		return "admindashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:home";
	}
	
}
