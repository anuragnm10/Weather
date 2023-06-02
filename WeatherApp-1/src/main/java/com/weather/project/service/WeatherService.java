package com.weather.project.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.project.dto.WeatherDTO;
import com.weather.project.dto.ForecastDTO;

@Service
public class WeatherService {
	private static final String apikey = "1cc5ff131590c0188c035e20b415c834";
	private static final String unit = "metric";

	WeatherDTO weatherdto = new WeatherDTO();

	public WeatherDTO weather(String city) throws JsonMappingException, JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apikey + "&units="
				+ unit;
		
		String response = restTemplate.getForObject(url, String.class);
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println(response);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(response);

		weatherdto.setCity(Character.toUpperCase(city.charAt(0))+city.substring(1));
		weatherdto.setVisibility(jsonNode.get("visibility").asDouble());
		JsonNode mainNode = jsonNode.get("main");
		if (mainNode != null) {
			weatherdto.setTemperature(mainNode.get("temp").asDouble());
			weatherdto.setFeelsLike(mainNode.get("feels_like").asDouble());
			weatherdto.setMinTemp(mainNode.get("temp_min").asDouble());
			weatherdto.setMaxTemp(mainNode.get("temp_max").asDouble());
			weatherdto.setPressure(mainNode.get("pressure").asInt());
			weatherdto.setHumidity(mainNode.get("humidity").asInt());
		}

		JsonNode weatherNode = jsonNode.get("weather");
		if (weatherNode != null && weatherNode.isArray()) {
			for (JsonNode node : weatherNode) {
				weatherdto.setWeather(node.get("main").asText() + "-" + node.get("description").asText());
			}
		}

		JsonNode windNode = jsonNode.get("wind");
		if (windNode != null) {
			weatherdto.setWindSpeed(windNode.get("speed").asDouble());
			weatherdto.setWindDegree(windNode.get("deg").asInt());
		}

		return weatherdto;
	}

	public List<ForecastDTO> forecast(String city) throws JsonMappingException, JsonProcessingException {
		System.out.println("I am in forecast() in weather service");
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + apikey + "&units="
				+ unit;
		String response = restTemplate.getForObject(url, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(response);

		List<ForecastDTO> weatherDataList = new ArrayList<>();

		JsonNode listNode = jsonNode.get("list");
		if (listNode != null && listNode.isArray()) {
			for (JsonNode node : listNode) {
				String date = node.get("dt_txt").asText().substring(0, 10);
				String time = node.get("dt_txt").asText().substring(11);
				double temperature = node.get("main").get("temp").asDouble();
				double feelsLike = node.get("main").get("feels_like").asDouble();
				double tempMin = node.get("main").get("temp_min").asDouble();
				double tempMax = node.get("main").get("temp_max").asDouble();
				int pressure = node.get("main").get("pressure").asInt();
				int humidity = node.get("main").get("humidity").asInt();
				String weather = node.get("weather").get(0).get("main").asText();
				String description = node.get("weather").get(0).get("description").asText();

				ForecastDTO forecastDTO = new ForecastDTO(date, time, temperature, feelsLike, tempMin, tempMax,
						pressure, humidity, weather, description);
				weatherDataList.add(forecastDTO);
			}
		}

		List<ForecastDTO> sortedForecast = weatherDataList.stream()
				.sorted(Comparator.comparing(ForecastDTO::getDate).thenComparing(ForecastDTO::getTime))
				.collect(Collectors.toList());

		return sortedForecast;

	}
}
