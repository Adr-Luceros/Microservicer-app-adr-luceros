package com.springboot.dto;

import java.sql.Time;

public class TiendaDTO {

	private String psEx;
	private String destinatario;
	private String nombreTienda;
	private String distrito;
	private String direccion;
	private Time horaInicio;
	private Time horaFin;
	private String contacto;
	
	public TiendaDTO() {
		
	}
	public TiendaDTO(String psEx, String destinatario, String nombreTienda, String distrito, String direccion,
			Time horaInicio, Time horaFin, String contacto) {
		
		this.psEx = psEx;
		this.destinatario = destinatario;
		this.nombreTienda = nombreTienda;
		this.distrito = distrito;
		this.direccion = direccion;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.contacto = contacto;
	}
	public String getPsEx() {
		return psEx;
	}
	public void setPsEx(String psEx) {
		this.psEx = psEx;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getNombreTienda() {
		return nombreTienda;
	}
	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Time getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	
}
