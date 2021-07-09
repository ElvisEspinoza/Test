package com.springboot.app.metereologia.model.service;

import java.util.Date;
import java.util.List;

import com.springboot.app.metereologia.model.entity.DatoMetereologico;

public interface IDatoMetereologicoService {

	public DatoMetereologico addRecord(DatoMetereologico datoMetereologico);
	public List<DatoMetereologico> findAll();
	public DatoMetereologico getDatoMeterologicoByDate(Date date);
	public void deleteAll();
	
}
