package com.springboot.dto;

import com.springboot.entity.Capacidad;

public class CamionDTO {

	private String marca;
	private String placa;
	private String tc;
	private String soat;
	
	private Capacidad capacidad;
	
	public Capacidad getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Capacidad capacidad) {
		this.capacidad = capacidad;
	}
	public CamionDTO() {
		
	}
	public CamionDTO(String marca, String placa, String tc, String soat) {
		
		this.marca = marca;
		this.placa = placa;
		this.tc = tc;
		this.soat = soat;
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
