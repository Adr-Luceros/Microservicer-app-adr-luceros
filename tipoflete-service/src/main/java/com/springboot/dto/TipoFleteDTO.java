package com.springboot.dto;

public class TipoFleteDTO {

	private String nombre;

	public TipoFleteDTO() {
		
	}

	public TipoFleteDTO(String nombre) {
		
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
