package com.springboot.dto;

import com.springboot.entity.Picking;
import com.springboot.entity.Ruta;
import com.springboot.entity.TipoFlete;
import com.springboot.entity.Viaje;

public class FleteDTO {

	private double volumenViaje;
	private String guia;
		
	private Picking picking;
	
	private Ruta ruta;
	
	private TipoFlete tipoFlete;
	
	private Viaje viaje;
	
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
	public FleteDTO() {
		
	}
	public FleteDTO(double volumenViaje, String guia) {
		
		this.volumenViaje = volumenViaje;
		this.guia = guia;
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
