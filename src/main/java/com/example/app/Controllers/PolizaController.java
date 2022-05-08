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

import com.example.app.Entities.Poliza;
import com.example.app.Services.PolizaService;

@RestController
@RequestMapping("/Polizas")
public class PolizaController {
	@Autowired
	PolizaService service;
	
	@GetMapping()
	public List<Poliza> listarPolizas(){
		return service.ListarPolizas();
	}
	@GetMapping(value = "/{id}")
	public Poliza buscarPoliza(@PathVariable Long id) {
		return service.BuscarPoliza(id);
	}
	@PutMapping(value = "/{id}")
	public void ModificarPoliza(@PathVariable Long id, @RequestBody Poliza poliza) {
		service.ModificarPoliza(id, poliza);
	}
	@DeleteMapping(value = "/{id}")
	public void EliminarPoliza(@PathVariable Long id) {
		service.EliminarPoliza(id,1,null);
	}
	@PostMapping()
	public void CrearPoliza(@RequestBody Poliza poliza) {
		poliza.setId(0);
		service.crearPoliza(poliza);
	}
}
