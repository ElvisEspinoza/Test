package com.springboot.app.metereologia.model.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "temperature")
public class Temperature implements Serializable{

	private static final long serialVersionUID = 4256338575296124554L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private Double temperature;		
	private WeatherData weatherData;
	
	public Temperature() {
	}

	public Temperature(Double temperature) {
		this.temperature = temperature;
	}
	
	public Temperature(Double temperature, WeatherData weatherData) {
		this.weatherData = weatherData;
		this.temperature = temperature;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "Temperature [id=" + id + ", temperature=" + temperature + ", weatherData=" + weatherData + "]";
	}
	
	
	
}
