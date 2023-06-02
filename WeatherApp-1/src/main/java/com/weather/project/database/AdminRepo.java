package com.weather.project.database;

import org.springframework.data.repository.CrudRepository;

import com.weather.project.entity.Admin;

public interface AdminRepo extends CrudRepository<Admin, Integer>{ 

	Admin findByEmail(String email);
}
