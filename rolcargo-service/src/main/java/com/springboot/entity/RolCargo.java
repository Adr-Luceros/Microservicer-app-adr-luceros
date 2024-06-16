package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RolCargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rolcargo_id;
	private String nombre;
	
	public RolCargo() {
		
	}
	public RolCargo(String nombre) {
		
		this.nombre = nombre;
	}
	public Integer getRolcargo_id() {
		return rolcargo_id;
	}
	public void setRolcargo_id(Integer rolcargo_id) {
		this.rolcargo_id = rolcargo_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
