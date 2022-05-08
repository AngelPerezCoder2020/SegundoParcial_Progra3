package com.example.app.Services;

import java.util.List;

import com.example.app.Entities.Poliza;

public interface PolizaService {
	public List<Poliza> ListarPolizas();
	public Poliza BuscarPoliza(Long ig);
	public void ModificarPoliza(Long id, Poliza poliza);
	public void EliminarPoliza(Long id1,int x,Long id2);
}
