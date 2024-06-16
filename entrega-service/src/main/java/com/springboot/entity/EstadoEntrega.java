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
public class EstadoEntrega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer estadoentrega_id;
	private String nombre;
	
	@OneToMany(mappedBy = "estadoEntrega", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Entrega> entrega;
	
	public List<Entrega> getEntrega() {
		return entrega;
	}
	public void setEntrega(List<Entrega> entrega) {
		this.entrega = entrega;
	}
	public EstadoEntrega() {
		
	}
	public EstadoEntrega(Integer estadoentrega_id, String nombre) {
		
		this.estadoentrega_id = estadoentrega_id;
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
