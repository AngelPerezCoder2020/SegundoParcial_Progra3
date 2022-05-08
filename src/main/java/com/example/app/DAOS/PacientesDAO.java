package com.example.app.DAOS;

import org.springframework.data.repository.CrudRepository;

import com.example.app.Entities.Paciente;

public interface PacientesDAO extends CrudRepository<Paciente,Long>{
	
}
