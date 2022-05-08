package com.example.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.Entities.Paciente;
import com.example.app.Services.PacienteService;

@RestController
@RequestMapping("/Pacientes")
public class PacienteController {
	@Autowired
	private PacienteService service;
	@GetMapping()
	public List<Paciente> ListarPacientes(){
		return service.ListarPacientes();
	}
	@GetMapping(value = "/{id}")
	public Paciente BuscarPaciente(@PathVariable Long id) {
		return service.findbyId(id);
	}
	@PutMapping(value = "/{id}")
	public void ModificarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
		service.ModificarPaciente(id, paciente);
	}
	@DeleteMapping(value ="/{id}")
	public void EliminarPaciente(@PathVariable Long id) {
		service.EliminarPaciente(id);
	}
	@PostMapping()
	public void NuevoPaciente(@RequestBody Paciente paciente) {
		paciente.setId(0);
		service.IngresarPaciente(paciente);
	}
}