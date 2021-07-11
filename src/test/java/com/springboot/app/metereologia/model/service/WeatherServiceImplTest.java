package com.springboot.app.metereologia.model.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.app.metereologia.model.dao.WeatherDataDao;
import com.springboot.app.metereologia.model.entity.Location;
import com.springboot.app.metereologia.model.entity.Temperature;
import com.springboot.app.metereologia.model.entity.WeatherData;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class WeatherServiceImplTest {	
	
	@InjectMocks
	private WeatherServiceImpl service;
	
	@Mock
	private WeatherDataDao weatherDao;	
	
	@BeforeEach
	public void init() {
		
	}
	
	@Test
	void findAllOrderedOk() {
		Mockito.when(weatherDao.findAll()).thenReturn(buildWeatherDataList());
		List<WeatherData> response = service.findAll();
		System.out.println("cero: " + response.get(0).getId());
		System.out.println("uno: " + response.get(1).getId());
		System.out.println("dos: " + response.get(2).getId());
		assertEquals(response.get(0).getId(), 1L);
		assertEquals(response.get(1).getId(), 2L);
		assertEquals(response.get(2).getId(), 3L);
	}
	
	@Test
	void findByDateOk() {
		Mockito.when(weatherDao.findAll()).thenReturn(buildWeatherDataList());
		List<WeatherData> response = service.findByDate("2020-01-01");
		assertEquals(response.size(), 2);
		Assertions.assertThat(response.get(0)).usingRecursiveComparison().isEqualTo(buildWeatherDataList().get(0));
		Assertions.assertThat(response.get(1)).usingRecursiveComparison().isEqualTo(buildWeatherDataList().get(1));
	}
	
	@Test
	void saveOk() {
		Mockito.when(weatherDao.save(any())).thenReturn(buildWeatherDataList().get(0));
		WeatherData response = service.save(buildWeatherDataList().get(0));
		System.out.println(response);
		Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(buildWeatherDataList().get(0));
	}
	
	@Test
	void deleteAllOk() {
		service.deleteAll();
		Mockito.verify(weatherDao, Mockito.times(1)).deleteAll();
	}
	
	private List<WeatherData> buildWeatherDataList() {
		
		List<WeatherData> weatherDataList = new ArrayList<>();
		
		WeatherData weatherData = new WeatherData();
		weatherData.setId(3L);
		weatherData.setCreateAt("2020-01-01");
		Location location = new Location();		
		List<Temperature> temperatures = new ArrayList<>();
		for(int i = 0; i < 24; i++) {
			Temperature temp = new Temperature(new Double(i));
			temperatures.add(temp);
		}
		location.setCity("Santiago");
		location.setLat("2.01");
		location.setLon("2.03");
		location.setState("Capital");	
		weatherData.setLocation(location);
		weatherData.setTemperature(temperatures);
		weatherDataList.add(weatherData);
		
		weatherData = new WeatherData();
		weatherData.setId(1L);
		weatherData.setCreateAt("2020-01-01");
		location = new Location();		
		temperatures = new ArrayList<>();
		for(int i = 0; i < 24; i++) {
			Temperature temp = new Temperature(new Double(i*2));
			temperatures.add(temp);
		}
		location.setCity("Asuncion");
		location.setLat("8.01");
		location.setLon("4.03");
		location.setState("Capital");	
		weatherData.setLocation(location);
		weatherData.setTemperature(temperatures);
		weatherDataList.add(weatherData);
		
		weatherData = new WeatherData();
		weatherData.setId(2L);
		weatherData.setCreateAt("2020-01-03");
		location = new Location();		
		temperatures = new ArrayList<>();
		for(int i = 0; i < 24; i++) {
			Temperature temp = new Temperature(new Double(i*3));
			temperatures.add(temp);
		}
		location.setCity("Brasilia");
		location.setLat("7.01");
		location.setLon("5.03");
		location.setState("Capital");	
		weatherData.setLocation(location);
		weatherData.setTemperature(temperatures);
		weatherDataList.add(weatherData);
		
		return weatherDataList;		
	}

}
