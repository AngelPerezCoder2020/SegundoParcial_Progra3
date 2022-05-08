package com.example.app.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_Paciente")
	private long id;
	@Column(name = "FirstName")
	private String FirstName;
	@Column(name = "SecondName")
	private String SecondName;
	@Column(name = "LastName")
	private String LastName;
	@Column(name = "SecondLastName")
	private String SecondLastName;
	@Column(name = "age")
	private int age;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="paciente",cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Poliza> polizas;
	
	public List<Poliza> getPolizas() {
		return polizas;
	}

	public void setPolizas(List<Poliza> polizas) {
		this.polizas = polizas;
	}

	public void addPoliza(Poliza poliza) {
		poliza.setPaciente(this);
		if(polizas==null) polizas = new ArrayList<>();
		polizas.add(poliza);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getSecondName() {
		return SecondName;
	}
	public void setSecondName(String secondName) {
		SecondName = secondName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getSecondLastName() {
		return SecondLastName;
	}
	public void setSecondLastName(String secondLastName) {
		SecondLastName = secondLastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}