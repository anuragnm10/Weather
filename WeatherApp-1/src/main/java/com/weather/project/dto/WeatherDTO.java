package com.weather.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDTO {
	
	private String city;
	private double temperature;
	private double feelsLike;
	private double minTemp;
	private double maxTemp;
	private int pressure;
	private int humidity;
	private double visibility;
	private double windSpeed;
	private int windDegree;
	private String weather;
	

}
