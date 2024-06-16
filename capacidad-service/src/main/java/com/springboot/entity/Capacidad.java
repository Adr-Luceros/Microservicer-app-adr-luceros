package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Capacidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer capacidad_id;
	private float volumen;
	
	public Capacidad() {
		
	}
	public Capacidad(float volumen) {
		
		this.volumen = volumen;
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
