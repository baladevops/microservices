package com.infy.ms.rest.fc;

import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${spring.application.appId}")
	private String appId;
	
	@RequestMapping("/forecast/{city}")
	@ResponseBody
	Forecast getForecast(@PathVariable String city) {
		//You may choose to validate city here...
		return forecastFor(city);
	}

	@RequestMapping("/forecast")
	@ResponseBody
	Forecast getForecast() {
		// default to Pune
		String city = "Pune";
		return forecastFor(city);
	}
	
	
	/**
	 * The hidden private method to invoke third party services
	 * @param city
	 * @return Forecast object
	 */
	private Forecast forecastFor(String city){
		RestTemplate restTemplate = new RestTemplate();

		System.out.println(" restTemplate :::" + restTemplate);
		Forecast forecast = restTemplate.getForObject(
				"http://api.openweathermap.org/data/2.5/forecast?q=" + city
						+ "&units=Metric&APPID="+appId, Forecast.class);

		return forecast;

	}
	
}
