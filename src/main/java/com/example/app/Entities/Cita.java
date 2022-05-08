package com.example.app.Entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "citas")
public class Cita {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cita")
	private long id;
	@Column(name="FechaCita")
	@Temporal(TemporalType.DATE)
	private Date FechaCita;
	@Column(name = "Hora")
	private String hora;
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "id_Poliza")
	@JsonBackReference
	private Poliza poliza;
	@Column(name = "estado")
	private String estado;
	@Column(name ="observaciones")
	private String observaciones;
	
	private Long poliza_id;
	
	public Long getPoliza_id() {
		return poliza_id;
	}
	public void setPoliza_id(Long poliza_id) {
		this.poliza_id = poliza_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getFechaCita() {
		return FechaCita;
	}
	public void setFechaCita(Date fechaCita) {
		FechaCita = fechaCita;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Poliza getPoliza() {
		return poliza;
	}
	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
