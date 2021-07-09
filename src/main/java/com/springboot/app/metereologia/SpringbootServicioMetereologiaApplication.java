package com.springboot.app.metereologia;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.app.metereologia.model.entity.Location;
import com.springboot.app.metereologia.model.entity.Temperature;
import com.springboot.app.metereologia.model.entity.WeatherData;
import com.springboot.app.metereologia.model.service.WeatherServiceImpl;

@SpringBootApplication
public class SpringbootServicioMetereologiaApplication implements CommandLineRunner  {
	
	@Autowired
	WeatherServiceImpl service;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioMetereologiaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.deleteAll();
		
		WeatherData weatherData = new WeatherData();
		weatherData.setCreateAt("2020-01-01");
		Location location = new Location();
		//List<Temperature> temperatures = Arrays.asList(new Temperature(1.0), new Temperature(2.0), new Temperature(3.0), new Temperature(4.0), new Temperature(5.0), new Temperature(6.0), new Temperature(7.0), new Temperature(8.0), new Temperature(9.0), new Temperature(10.0));		
		//List<Temperature> temperatures = Arrays.asList(new Temperature(1L, 1.0), new Temperature(2L, 2.0));//
		Temperature temp = new Temperature();
		Temperature temp2 = new Temperature();
		temp.setTemperature(1.0);
		temp2.setTemperature(2.0);
		List<Temperature> temperatures = Arrays.asList(temp, temp2);
		location.setCity("Santiago");
		location.setLat("2.01");
		location.setLon("2.03");
		location.setState("Capital");	
		weatherData.setLocation(location);
		weatherData.setTemperature(temperatures);
		service.save(weatherData);
		
		WeatherData weatherData2 = new WeatherData();
		weatherData2.setCreateAt("2020-01-02");
		location.setCity("Brasilia");
		location.setLat("8.01");
		location.setLon("9.03");
		location.setState("Capital");		
		weatherData2.setLocation(location);
		service.save(weatherData2);
		
		WeatherData weatherData3 = new WeatherData();
		weatherData3.setCreateAt("2020-01-03");
		location.setCity("Asuncion");
		location.setLat("5.01");
		location.setLon("25.03");
		location.setState("Capital");			
		weatherData3.setLocation(location);
		service.save(weatherData3);
		
		WeatherData weatherData4 = new WeatherData();
		weatherData4.setCreateAt("2020-01-04");
		location.setCity("Lima");
		location.setLat("45.01");
		location.setLon("90.03");
		location.setState("Capital");			
		weatherData4.setLocation(location);
		service.save(weatherData4);
		
		WeatherData weatherData5 = new WeatherData();
		weatherData5.setCreateAt("2020-01-05");
		location.setCity("La Paz");
		location.setLat("59.01");
		location.setLon("77.03");
		location.setState("Capital");			
		weatherData5.setLocation(location);
		service.save(weatherData5);		
	}

}
