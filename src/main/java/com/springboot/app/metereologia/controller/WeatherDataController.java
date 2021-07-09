package com.springboot.app.metereologia.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.metereologia.model.entity.WeatherData;
import com.springboot.app.metereologia.model.service.WeatherServiceImpl;

@RestController
public class WeatherDataController{
	
	@Autowired
	WeatherServiceImpl service;
	
	@PostMapping("/weather")
	public WeatherData addRecord(@RequestBody WeatherData weatherData) {
		return service.save(weatherData);
	}
	
	@GetMapping("/weather")
	public List<WeatherData> findAll() {
		return service.findAll();
	}
	
	@GetMapping
	public List<WeatherData> findByDate(@RequestParam String date) {
		return service.findByDate(date);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAll() {
		service.deleteAll();
		return ResponseEntity.accepted().build();
	}
	
}
