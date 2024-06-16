package com.springboot.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class RolCargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rolcargo_id;
	private String nombre;
		
	@OneToMany(mappedBy = "rolCargo", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Cargo> cargo;
	
	public List<Cargo> getCargo() {
		return cargo;
	}
	public void setCargo(List<Cargo> cargo) {
		this.cargo = cargo;
	}
	public RolCargo() {
		
	}
	public RolCargo(Integer rolcargo_id, String nombre) {
		
		this.rolcargo_id = rolcargo_id;
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
