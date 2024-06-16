package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ruta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ruta_id;
	private String nombre;
	
	public Ruta() {
		
	}
	public Ruta(String nombre) {
		
		this.nombre = nombre;
	}
	public Integer getRuta_id() {
		return ruta_id;
	}
	public void setRuta_id(Integer ruta_id) {
		this.ruta_id = ruta_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
