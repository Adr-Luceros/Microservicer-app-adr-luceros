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
public class Camion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer camion_id;
	private String marca;
	private String placa;
	private String tc;
	private String soat;
	
	@OneToMany(mappedBy = "camion", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Viaje> viaje;
	
	public List<Viaje> getViaje() {
		return viaje;
	}
	public void setViaje(List<Viaje> viaje) {
		this.viaje = viaje;
	}
	public Camion() {
		
	}
	public Camion(Integer camion_id, String marca, String placa, String tc, String soat) {
		
		this.camion_id = camion_id;
		this.marca = marca;
		this.placa = placa;
		this.tc = tc;
		this.soat = soat;
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
