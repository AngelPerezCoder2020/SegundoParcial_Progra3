package com.example.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.DAOS.PacientesDAO;
import com.example.app.Entities.Paciente;
import com.example.app.Entities.Poliza;

@Service
public class PacienteServiceIMp implements PacienteService{
	
	@Autowired
	private PacientesDAO dao;
	
	@Autowired
	private PolizaService ServicePolizas;
	
	@Override
	public void IngresarPaciente(Paciente paciente) {
		dao.save(paciente);
	}

	@Override
	public List<Paciente> ListarPacientes() {
		return (List<Paciente>) dao.findAll();
	}

	@Override
	public Paciente findbyId(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void ModificarPaciente(Long id, Paciente paciente) {
		if(dao.existsById(id)) {
			paciente.setId(id);
			dao.save(paciente);
		}
	}

	@Override
	public void EliminarPaciente(Long id) {
		if(dao.existsById(id)) {
			Paciente pa = dao.findById(id).orElse(null);
			for(Poliza po:pa.getPolizas()) {
				ServicePolizas.EliminarPoliza(po.getId(), 2, id);
			}
			dao.deleteById(id);
		}
	}
}