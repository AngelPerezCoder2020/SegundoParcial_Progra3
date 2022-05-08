package com.example.app.DAOS;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.Entities.Cita;

@Repository
public interface CitasDAO extends CrudRepository<Cita, Long>{
	@Modifying
	@Transactional
	@Query(value="UPDATE citas SET estado = ?1 WHERE id_cita = ?2",
			nativeQuery = true)
	public void aceptarCita(String estado, Long id);
	
	@Modifying
	@Transactional
	@Query(value="DELETE FROM citas WHERE id_poliza = ?1",
			nativeQuery=true)
	public void LimpiarCitas(Long id);
}