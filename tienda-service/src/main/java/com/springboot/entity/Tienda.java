package com.springboot.entity;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tienda {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer tienda_id;
	private String psEx;
	private String destinatario;
	private String nombreTienda;
	private String distrito;
	private String direccion;
	private Time horaInicio;
	private Time horaFin;
	private String contacto;
	
	public Tienda() {
		
	}
	public Tienda(String psEx, String destinatario, String nombreTienda, String distrito,
			String direccion, Time horaInicio, Time horaFin, String contacto) {
		
		this.psEx = psEx;
		this.destinatario = destinatario;
		this.nombreTienda = nombreTienda;
		this.distrito = distrito;
		this.direccion = direccion;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.contacto = contacto;
	}
	public Integer getTienda_id() {
		return tienda_id;
	}
	public void setTienda_id(Integer tienda_id) {
		this.tienda_id = tienda_id;
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
