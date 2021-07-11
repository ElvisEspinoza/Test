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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "weather_data")
public class WeatherData implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "create_at")
	private String createAt;
	
	private Location location;
	
	//@OneToMany(mappedBy="weatherData", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name ="cp_fk")
    @OneToMany(targetEntity = Temperature.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="weather_data_fk")//weather_data_fk queda asociado a un campo llamado weather_data_fk en la tabla de la clase Temperature
	private List<Temperature> temperature;
	
	
	public WeatherData() {
	}

	public WeatherData(Long id, String createAt, Location location, List<Temperature> temperature) {
		this.id = id;
		this.createAt = createAt;
		this.location = location;
		this.temperature = temperature;
	}
	
	public WeatherData(String createAt, Location location, List<Temperature> temperature) {
		this.createAt = createAt;
		this.location = location;
		this.temperature = temperature;
	}
	
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
	}
	public List<Temperature> getTemperature() {
		return temperature;
	}
	public void setTemperature(List<Temperature> temperature) {
		this.temperature = temperature;
	}


	private static final long serialVersionUID = 1285454306356845809L;


}
