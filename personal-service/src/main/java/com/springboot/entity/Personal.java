package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personal {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer personal_id;
	private String nombre;
	private String telefono;
	private String nroDocumento;
	private String tipoDocumento;
		
	public Personal() {
		
	}
	public Personal(String nombre, String telefono, String nroDocumento, String tipoDocumento) {
		
		this.nombre = nombre;
		this.telefono = telefono;
		this.nroDocumento = nroDocumento;
		this.tipoDocumento = tipoDocumento;
	}
	public Integer getPersonal_id() {
		return personal_id;
	}
	public void setPersonal_id(Integer personal_id) {
		this.personal_id = personal_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	
	
	
}
