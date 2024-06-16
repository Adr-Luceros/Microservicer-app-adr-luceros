package com.springboot.dto;

import com.springboot.entity.Capacidad;
import com.springboot.entity.Ruta;
import com.springboot.entity.TipoFlete;

public class TarifarioDTO {

	private Capacidad capacidad;
	private Ruta ruta;
	private TipoFlete tipoFlete;
	
	public TarifarioDTO() {
		super();
	}
	public Capacidad getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Capacidad capacidad) {
		this.capacidad = capacidad;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	public TipoFlete getTipoFlete() {
		return tipoFlete;
	}
	public void setTipoFlete(TipoFlete tipoFlete) {
		this.tipoFlete = tipoFlete;
	}
	
	
}
