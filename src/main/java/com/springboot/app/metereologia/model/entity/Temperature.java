package com.springboot.app.metereologia.model.entity;


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
public class Temperature {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	Double temperature;
	
	@ManyToOne
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private WeatherData weatherData;
}
