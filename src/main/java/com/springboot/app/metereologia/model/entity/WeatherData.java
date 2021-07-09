package com.springboot.app.metereologia.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "weather_data")
public class WeatherData implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "create_at")
	private String createAt;
	
	private Location location;
	
	@OneToMany(mappedBy="temperature", cascade = CascadeType.ALL)
	private List<Temperature> temperature;	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}/*
	public List<Temperature> getTemperature() {
		return temperature;
	}
	public void setTemperature(List<Temperature> temperature) {
		this.temperature = temperature;
	}*/


	private static final long serialVersionUID = 1285454306356845809L;


}
