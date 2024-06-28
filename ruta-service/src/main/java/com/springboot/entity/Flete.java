package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Flete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flete_id;
	private double volumenViaje;
	private String guia;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "picking_id")
	private Picking picking;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ruta_id")
	private Ruta ruta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipoflete_id")
	private TipoFlete tipoFlete;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "viaje_id")
	private Viaje viaje;
	
	public Flete() {
		
	}
	public Flete(double volumenViaje, String guia, Picking picking, Ruta ruta, TipoFlete tipoFlete, Viaje viaje) {
		
		this.volumenViaje = volumenViaje;
		this.guia = guia;
		this.picking = picking;
		this.ruta = ruta;
		this.tipoFlete = tipoFlete;
		this.viaje = viaje;
	}
	public Viaje getViaje() {
		return viaje;
	}
	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}
	public TipoFlete getTipoFlete() {
		return tipoFlete;
	}
	public void setTipoFlete(TipoFlete tipoFlete) {
		this.tipoFlete = tipoFlete;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	public Picking getPicking() {
		return picking;
	}
	public void setPicking(Picking picking) {
		this.picking = picking;
	}
	public Integer getFlete_id() {
		return flete_id;
	}
	public void setFlete_id(Integer flete_id) {
		this.flete_id = flete_id;
	}
	public double getVolumenViaje() {
		return volumenViaje;
	}
	public void setVolumenViaje(double volumenViaje) {
		this.volumenViaje = volumenViaje;
	}
	public String getGuia() {
		return guia;
	}
	public void setGuia(String guia) {
		this.guia = guia;
	}
	
    
    
    
}
