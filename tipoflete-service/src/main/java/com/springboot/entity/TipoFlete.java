package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoFlete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tipoflete_id;
	private String nombre;
	
	public TipoFlete() {
		
	}
	public TipoFlete(String nombre) {
		
		this.nombre = nombre;
	}
	public Integer getTipoflete_id() {
		return tipoflete_id;
	}
	public void setTipoflete_id(Integer tipoflete_id) {
		this.tipoflete_id = tipoflete_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
