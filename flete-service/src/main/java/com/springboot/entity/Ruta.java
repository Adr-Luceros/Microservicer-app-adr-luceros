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
public class Ruta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ruta_id;
	private String nombre;
	
	@OneToMany(mappedBy = "ruta", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Flete> flete;
	
	public Ruta() {
		super();
	}
	public Ruta(Integer ruta_id, String nombre) {
		
		this.ruta_id = ruta_id;
		this.nombre = nombre;
	}
	public List<Flete> getFlete() {
		return flete;
	}
	public void setFlete(List<Flete> flete) {
		this.flete = flete;
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
