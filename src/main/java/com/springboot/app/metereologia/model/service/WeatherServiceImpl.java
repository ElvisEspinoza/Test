package com.springboot.app.metereologia.model.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.metereologia.model.dao.WeatherDataDao;
import com.springboot.app.metereologia.model.entity.WeatherData;


@Service
public class WeatherServiceImpl implements IWeatherDataService{

	@Autowired
	private WeatherDataDao weatherDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<WeatherData> findAll() {
		return weatherDao.findAll().stream().sorted(Comparator.comparing(WeatherData::getId)).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<WeatherData> findByDate(String date) {
		return weatherDao.findAll().stream()
				.filter(data -> data.getCreateAt().equals(date))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public WeatherData save(WeatherData weatherData) {
		return weatherDao.save(weatherData);
	}

	@Override
	@Transactional
	public void deleteAll() {
		weatherDao.deleteAll();
	}

}
