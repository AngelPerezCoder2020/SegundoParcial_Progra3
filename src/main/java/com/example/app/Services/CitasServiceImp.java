package com.example.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.DAOS.CitasDAO;
import com.example.app.Entities.Cita;

@Service
public class CitasServiceImp implements CitasService{

	@Autowired
	private CitasDAO dao;
	
	@Override
	public List<Cita> ListarCitas() {
		return (List<Cita>)dao.findAll();
	}

	@Override
	public Cita buscarCita(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void AgendarCita(Cita cita) {
		dao.save(cita);
		
	}

	@Override
	public void AceptarCita(String estado, Long id) {
		if(dao.existsById(id)) dao.aceptarCita(estado, id);
	}

	@Override
	public void BorrarCita(Long id) {
		if(dao.existsById(id)) dao.deleteById(id);
	}
}