package com.weather.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.project.database.AdminRepo;
import com.weather.project.database.UserRepo;
import com.weather.project.entity.Admin;
import com.weather.project.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepo userdb;
	
	@Autowired
	private AdminRepo admindb;
	
	public List<User> getAllUsers() throws Exception{
		List<User> list = new ArrayList<>();
		try {
			userdb.findAll().forEach(list::add);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return list;
	}
	
	public User getUserByEmail(String email) throws Exception{
		User user;
		try {
			user = userdb.findByEmail(email);
		}catch(EntityNotFoundException e) {
			throw new Exception(e.getMessage());
		}
		
		return user;
	}
	
	public Admin getAdminByEmail(String email) throws Exception{
		Admin admin;
		try {
			admin = admindb.findByEmail(email);
		}catch(EntityNotFoundException e) {
			throw new Exception(e.getMessage());
		}
		
		return admin;
	}
	
	public void insertUser(User user) throws Exception{
			userdb.save(user);
	}
	
	public void insertAdmin(Admin admin) throws Exception{
			admindb.save(admin);
	}
	
	public boolean validateForAdmin(Admin admin, String password) throws Exception {
		try {
			if (admin.getPassword().equals(password)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("Invalid credentials!");
		}

		return false;
	}

	public boolean validateForUser(User user, String password) throws Exception {

		try {
			if (user.getPassword().equals(password)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("Invalid credentials!");
		}

		return false;
	}
	
	public User getUserById(int id) throws Exception{
		User user;
		try {
			user = userdb.findById(id);
		}catch(Exception e) {
			throw new EntityNotFoundException();
		}
		return user;
	}
	
}
