package com.springboot.app.metereologia.model.service;

import java.util.Date;
import java.util.List;

import com.springboot.app.metereologia.model.entity.WeatherData;


public interface IWeatherDataService {

	public List<WeatherData> findAll();
	public List<WeatherData> findByDate(Date date);	
	public WeatherData save(WeatherData weatherData);	
	public void deleteAll();
}
