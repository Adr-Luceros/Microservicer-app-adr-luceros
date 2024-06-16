package com.springboot.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Viaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer viaje_id;
	private Date fechaSalida;
	private String almacen;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "camion_id")
	private Camion camion;
	
	public Viaje(Date fechaSalida, String almacen, Camion camion) {
		
		this.fechaSalida = fechaSalida;
		this.almacen = almacen;
		this.camion = camion;
	}
	public Camion getCamion() {
		return camion;
	}
	public void setCamion(Camion camion) {
		this.camion = camion;
	}
	public Viaje() {
		
	}
	
	public Integer getViaje_id() {
		return viaje_id;
	}
	public void setViaje_id(Integer viaje_id) {
		this.viaje_id = viaje_id;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getAlmacen() {
		return almacen;
	}
	public void setAlmacen(String almacen) {
		this.almacen = almacen;
	}
	
	
}
