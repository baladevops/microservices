package com.infy.microservice.rest;

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.model.Weather;

@RestController
@EnableAutoConfiguration
public class WeatherForecastController {
	
	@Value("${spring.application.appId}")
	private String appId;

	@RequestMapping("/weather/{city}")
	@ResponseBody
	Weather getWeather(@PathVariable String city) {
		//You may choose to validate CITY here...
		return weatherFor(city);
		
	}

	@RequestMapping("/weather")
	@ResponseBody
	Weather getWeather() {
		// default to Pune
		String city = "Pune";
		return weatherFor(city);
	}

	/**
	 * Private method to invoke third party REST services
	 * @param city
	 * @return WeatherForecast object
	 */
	private Weather weatherFor(String city){
		RestTemplate restTemplate = new RestTemplate();

		System.out.println(" restTemplate :::" + restTemplate);
		System.out.println("Using APPID:"+appId);
		Weather weather = restTemplate.getForObject(
				"http://api.openweathermap.org/data/2.5/weather?q=" + city
						+ "&units=Metric&APPID="+appId, Weather.class);

		return weather;
	}
	
}
