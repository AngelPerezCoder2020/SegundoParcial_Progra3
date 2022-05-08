package com.example.app.Services;

import java.util.List;

import com.example.app.Entities.Cita;

public interface CitasService {
	public List<Cita> ListarCitas();
	public Cita buscarCita(Long id);
	public void AgendarCita(Cita cita);
	public void AceptarCita(String estado, Long id);
	public void BorrarCita(Long id);
}
