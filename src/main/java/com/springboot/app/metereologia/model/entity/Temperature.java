package com.springboot.app.metereologia.model.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 4256338575296124554L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	Double temperature;		
	
	public Temperature(Double temperature) {
		this.temperature = temperature;
	}

	@ManyToOne
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private WeatherData weatherData;
/*
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
	}*/
	
	
	
	
	
}
