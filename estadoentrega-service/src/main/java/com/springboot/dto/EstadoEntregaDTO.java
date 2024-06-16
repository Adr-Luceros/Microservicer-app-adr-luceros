package com.springboot.dto;

public class EstadoEntregaDTO {

	private String nombre;

	public EstadoEntregaDTO() {
		
	}

	public EstadoEntregaDTO(String nombre) {
		
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
