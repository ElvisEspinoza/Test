package com.springboot.app.metereologia.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.metereologia.model.entity.WeatherData;

public interface WeatherDataDao extends JpaRepository<WeatherData, Long>{

}
