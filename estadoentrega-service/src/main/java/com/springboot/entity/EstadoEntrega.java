package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EstadoEntrega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer estadoentrega_id;
	private String nombre;
	
	public EstadoEntrega() {
		
	}
	public EstadoEntrega(String nombre) {
		
		this.nombre = nombre;
	}
	public Integer getEstadoentrega_id() {
		return estadoentrega_id;
	}
	public void setEstadoentrega_id(Integer estadoentrega_id) {
		this.estadoentrega_id = estadoentrega_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
