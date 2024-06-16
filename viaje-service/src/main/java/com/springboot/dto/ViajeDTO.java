package com.springboot.dto;

import java.util.Date;

import com.springboot.entity.Camion;

public class ViajeDTO {

	private Date fechaSalida;
	private String almacen;
	
	private Camion camion;
	
	public Camion getCamion() {
		return camion;
	}
	public void setCamion(Camion camion) {
		this.camion = camion;
	}
	public ViajeDTO() {
	
	}
	public ViajeDTO(Date fechaSalida, String almacen) {
	
		this.fechaSalida = fechaSalida;
		this.almacen = almacen;
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
