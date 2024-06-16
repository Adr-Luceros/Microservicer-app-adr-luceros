package com.springboot.dto;

public class EstadoPickingDTO {

	private String nombre;
	
	public EstadoPickingDTO() {
		
	}

	public EstadoPickingDTO(String nombre) {
		
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
