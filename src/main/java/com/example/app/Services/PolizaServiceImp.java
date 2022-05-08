package com.example.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.DAOS.CitasDAO;
import com.example.app.DAOS.PolizaDAO;
import com.example.app.Entities.Poliza;

@Service
public class PolizaServiceImp implements PolizaService{
	
	@Autowired
	private PolizaDAO dao;
	
	@Autowired
	private CitasDAO daoCitas;
	
	@Override
	public List<Poliza> ListarPolizas() {
		return (List<Poliza>)dao.findAll();
	}

	@Override
	public Poliza BuscarPoliza(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void ModificarPoliza(Long id, Poliza poliza) {
		if(dao.existsById(id)) {
			Long id_p = dao.recuperar_id(id);
			poliza.setId(id);
			dao.save(poliza);
			dao.mantenerPaciente(id_p, id);
		}
	}

	@Override
	public void EliminarPoliza(Long id1,int x,Long id2) {
		if(x==1&&dao.existsById(id1)) {
			dao.deleteById(id1);
			daoCitas.LimpiarCitas(id1);
		}else if(x==2) {
			dao.LimpiarPolizas(id2);
			daoCitas.LimpiarCitas(id1);
		}
	}
}