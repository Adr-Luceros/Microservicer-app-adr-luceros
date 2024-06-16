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
public class EstadoPicking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer estadopicking_id;
	private String nombre;
	
	@OneToMany(mappedBy = "estadoPicking", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Picking> picking;
	
	public EstadoPicking() {
		
	}
	public EstadoPicking(Integer estadopicking_id, String nombre) {
		
		this.estadopicking_id = estadopicking_id;
		this.nombre = nombre;
	}
	public List<Picking> getPicking() {
		return picking;
	}
	public void setPicking(List<Picking> picking) {
		this.picking = picking;
	}
	public Integer getEstadopicking_id() {
		return estadopicking_id;
	}
	public void setEstadopicking_id(Integer estadopicking_id) {
		this.estadopicking_id = estadopicking_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
