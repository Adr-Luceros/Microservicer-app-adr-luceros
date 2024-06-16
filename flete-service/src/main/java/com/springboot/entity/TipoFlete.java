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
public class TipoFlete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tipoflete_id;
	private String nombre;
	
	@OneToMany(mappedBy = "tipoFlete", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Flete> flete;
	
	public TipoFlete() {
		
	}
	public TipoFlete(Integer tipoflete_id, String nombre) {
		
		this.tipoflete_id = tipoflete_id;
		this.nombre = nombre;
	}
	public List<Flete> getFlete() {
		return flete;
	}
	public void setFlete(List<Flete> flete) {
		this.flete = flete;
	}
	public Integer getTipoflete_id() {
		return tipoflete_id;
	}
	public void setTipoflete_id(Integer tipoflete_id) {
		this.tipoflete_id = tipoflete_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
