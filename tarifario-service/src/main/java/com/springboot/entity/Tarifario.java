package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tarifario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tarifario_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "capacidad_id")
	private Capacidad capacidad;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ruta_id")
	private Ruta ruta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipoflete_id")
	private TipoFlete tipoFlete;
	
	public Tarifario() {
		
	}

	public Tarifario(Capacidad capacidad, Ruta ruta, TipoFlete tipoFlete) {
		
		this.capacidad = capacidad;
		this.ruta = ruta;
		this.tipoFlete = tipoFlete;
	}

	public TipoFlete getTipoFlete() {
		return tipoFlete;
	}

	public void setTipoFlete(TipoFlete tipoFlete) {
		this.tipoFlete = tipoFlete;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public Capacidad getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Capacidad capacidad) {
		this.capacidad = capacidad;
	}

	public Integer getTarifario_id() {
		return tarifario_id;
	}

	public void setTarifario_id(Integer tarifario_id) {
		this.tarifario_id = tarifario_id;
	}
	
	
	
}
