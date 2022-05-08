package com.example.app.DAOS;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.app.Entities.Poliza;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PolizaDAO extends CrudRepository<Poliza, Long>{

	@Modifying
	@Transactional
	@Query(value="DELETE FROM polizas WHERE id_paciente = ?1",
			nativeQuery=true)
	public void LimpiarPolizas(Long id);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE polizas SET id_paciente = ?1  WHERE id_poliza = ?2",
			nativeQuery = true)
	public void mantenerPaciente(Long id1, Long id2);

	@Query(value="SELECT id_paciente FROM polizas WHERE id_poliza = ?1",
			nativeQuery = true)
	public Long recuperar_id(Long id);
}