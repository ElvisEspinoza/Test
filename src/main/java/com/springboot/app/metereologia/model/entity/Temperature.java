package com.springboot.app.metereologia.model.entity;


import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "temperature")
public class Temperature implements Serializable{

	private static final long serialVersionUID = 4256338575296124554L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_temp")
	private Long id;	
	private Double temperature;		
		
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName="id"/*, insertable = false, updatable = false*/)
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public WeatherData getWeatherData() {
		return weatherData;
	}

	public void setWeatherData(WeatherData weatherData) {
		this.weatherData = weatherData;
	}
	
}
