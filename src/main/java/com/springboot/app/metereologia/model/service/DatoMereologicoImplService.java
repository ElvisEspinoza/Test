package com.springboot.app.metereologia.model.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.metereologia.model.dao.IDatoMetereologicoDao;
import com.springboot.app.metereologia.model.entity.DatoMetereologico;

@Service
public class DatoMereologicoImplService implements IDatoMetereologicoService {
	
	@Autowired
	IDatoMetereologicoDao datoMetereologico;

	@Override
	public DatoMetereologico addRecord(DatoMetereologico datoMetereologico) {
		//datoMetereologico.
		return null;
	}

	@Override
	public List<DatoMetereologico> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatoMetereologico getDatoMeterologicoByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
