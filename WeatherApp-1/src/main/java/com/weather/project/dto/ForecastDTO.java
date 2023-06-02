package com.weather.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForecastDTO {
	
	private String date;
	private String time;
	private double temperature;
	private double feelsLike;
	private double tempMin;
	private double tempMax;
	private int pressure;
	private int humidity;
	private String weather;
	private String description;
}
