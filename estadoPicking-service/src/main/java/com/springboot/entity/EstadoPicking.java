package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EstadoPicking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer estadopicking_id;
	private String nombre;
		
	public EstadoPicking() {
		
	}
	public EstadoPicking(String nombre) {
		
		this.nombre = nombre;
	}
	public Integer getEstadopicking_id() {
		return estadopicking_id;
	}
	public void setEstadopicking_id(Integer estadopicking_id) {
		this.estadopicking_id = estadopicking_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
