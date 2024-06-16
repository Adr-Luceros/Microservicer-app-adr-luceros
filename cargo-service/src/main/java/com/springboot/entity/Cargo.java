package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cargo_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "personal_id")
	private Personal personal;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rolcargo_id")
	private RolCargo rolCargo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "viaje_id")
	private Viaje viaje;
	
	public Cargo(Personal personal, RolCargo rolCargo, Viaje viaje) {
		
		this.personal = personal;
		this.rolCargo = rolCargo;
		this.viaje = viaje;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public RolCargo getRolCargo() {
		return rolCargo;
	}

	public void setRolCargo(RolCargo rolCargo) {
		this.rolCargo = rolCargo;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Cargo() {
		
	}

	public Integer getCargo_id() {
		return cargo_id;
	}

	public void setCargo_id(Integer cargo_id) {
		this.cargo_id = cargo_id;
	}
	
	
}
