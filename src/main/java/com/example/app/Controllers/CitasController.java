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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.Entities.Cita;
import com.example.app.Services.CitasService;

@RestController
@RequestMapping("/Citas")
public class CitasController {
	@Autowired
	private CitasService service;
	
	@GetMapping()
	public List<Cita> ListarCitas(){
		return service.ListarCitas();
	}
	@GetMapping(value = "/{id}")
	public Cita BuscarCita(@PathVariable Long id) {
		return service.buscarCita(id);
	}
	@PostMapping()
	public void AgendarCita(@RequestBody Cita cita) {
		cita.setId(0);
		service.AgendarCita(cita);
	}
	@PutMapping(value = "/{id}")
	public void AceptarCita(@PathVariable Long id, @RequestParam(value="estado",defaultValue="CANCELADA")String estado) {
		service.AceptarCita(estado, id);
	}
	@DeleteMapping(value = "/{id}")
	public void EliminarCita(@PathVariable Long id) {
		service.BorrarCita(id);
	}

}
