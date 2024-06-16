package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Camion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer camion_id;
	private String marca;
	private String placa;
	private String tc;
	private String soat;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "capacidad_id")
	private Capacidad capacidad;
	
	public Capacidad getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Capacidad capacidad) {
		this.capacidad = capacidad;
	}
	public Camion() {
		
	}
	
	public Camion(String marca, String placa, String tc, String soat, Capacidad capacidad) {
		
		this.marca = marca;
		this.placa = placa;
		this.tc = tc;
		this.soat = soat;
		this.capacidad = capacidad;
	}
	public Integer getCamion_id() {
		return camion_id;
	}
	public void setCamion_id(Integer camion_id) {
		this.camion_id = camion_id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getSoat() {
		return soat;
	}
	public void setSoat(String soat) {
		this.soat = soat;
	}
	
	
}
