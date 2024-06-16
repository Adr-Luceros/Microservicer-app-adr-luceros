package com.springboot.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Viaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer viaje_id;
	private Date fechaSalida;
	private String almacen;
	
	@OneToMany(mappedBy = "viaje", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Flete> flete;
		
	public Viaje() {
		
	}
	public Viaje(Integer viaje_id, Date fechaSalida, String almacen) {
		
		this.viaje_id = viaje_id;
		this.fechaSalida = fechaSalida;
		this.almacen = almacen;
	}
	public List<Flete> getFlete() {
		return flete;
	}
	public void setFlete(List<Flete> flete) {
		this.flete = flete;
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
