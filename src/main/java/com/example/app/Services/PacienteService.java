package com.example.app.Services;

import java.util.List;

import com.example.app.Entities.Paciente;

public interface PacienteService {
	public void IngresarPaciente(Paciente paciente);
	public List<Paciente> ListarPacientes();
	public Paciente findbyId(Long id);
	public void ModificarPaciente(Long id,Paciente paciente);
	public void EliminarPaciente(Long id);
}