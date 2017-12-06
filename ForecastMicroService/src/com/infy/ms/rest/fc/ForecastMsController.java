package com.infy.ms.rest.fc;

import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.ms.rest.model.Forecast;

@RestController
@EnableAutoConfiguration
public class ForecastMsController {
	
	
	@RequestMapping("/forecast/{city}")
	@ResponseBody
	Forecast getForecast(@PathVariable String city) {		
		return getStubForecastData(city);
	}

	@RequestMapping("/forecast")
	@ResponseBody
	Forecast getForecast() {
		// default to Pune
		String city = "Pune";
		
		return getStubForecastData(city);
		
	}
	
	private Forecast getStubForecastData(String city){
		String mockFile = "/data/forecast_"+city.toLowerCase()+".json";
		ObjectMapper objectMapper = new ObjectMapper();
		Forecast forecast = null;
		try {
			InputStream stream = getClass().getResourceAsStream(mockFile);
			forecast = objectMapper.readValue(stream, Forecast.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return forecast;
	}
	
}
