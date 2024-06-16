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
public class Capacidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer capacidad_id;
	private float volumen;
	
	@OneToMany(mappedBy = "capacidad", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Tarifario> tarifario;	
	
	public Capacidad() {
		
	}
	public Capacidad(Integer capacidad_id, float volumen) {
		
		this.capacidad_id = capacidad_id;
		this.volumen = volumen;
	}
	public List<Tarifario> getTarifario() {
		return tarifario;
	}
	public void setTarifario(List<Tarifario> tarifario) {
		this.tarifario = tarifario;
	}
	public Integer getCapacidad_id() {
		return capacidad_id;
	}
	public void setCapacidad_id(Integer capacidad_id) {
		this.capacidad_id = capacidad_id;
	}
	public float getVolumen() {
		return volumen;
	}
	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}
	
	
}
