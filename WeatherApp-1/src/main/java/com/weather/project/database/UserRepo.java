package com.weather.project.database;

import org.springframework.data.repository.CrudRepository;

import com.weather.project.entity.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	
	User findByEmail(String email);
	User findById(int id);

}
