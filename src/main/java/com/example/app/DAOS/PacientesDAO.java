package com.example.app.DAOS;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.Entities.Paciente;

public interface PacientesDAO extends CrudRepository<Paciente,Long>{
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM pacientes WHERE id_paciente = ?1",
			nativeQuery=true)
	public void deleteById(Long id);
}
