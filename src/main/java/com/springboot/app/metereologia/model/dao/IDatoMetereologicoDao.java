package com.springboot.app.metereologia.model.dao;

import org.springframework.data.repository.CrudRepository;
import com.springboot.app.metereologia.model.entity.DatoMetereologico;

public interface IDatoMetereologicoDao extends CrudRepository<DatoMetereologico, Long>{

}
