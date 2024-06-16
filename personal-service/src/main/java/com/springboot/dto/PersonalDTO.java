package com.springboot.dto;

public class PersonalDTO {

	private String nombre;
	private String telefono;
	private String nroDocumento;
	private String tipoDocumento;
		
	public PersonalDTO() {
		
	}
	public PersonalDTO(String nombre, String telefono, String nroDocumento, String tipoDocumento) {
		
		this.nombre = nombre;
		this.telefono = telefono;
		this.nroDocumento = nroDocumento;
		this.tipoDocumento = tipoDocumento;
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
