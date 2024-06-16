package com.springboot.dto;

import com.springboot.entity.EstadoEntrega;
import com.springboot.entity.Tienda;
import com.springboot.entity.Viaje;

public class EntregaDTO {

	private String observaciones;

	private EstadoEntrega estadoEntrega;
	
	private Tienda tienda;
	
	private Viaje viaje;
	
	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public EstadoEntrega getEstadoEntrega() {
		return estadoEntrega;
	}

	public void setEstadoEntrega(EstadoEntrega estadoEntrega) {
		this.estadoEntrega = estadoEntrega;
	}

	public EntregaDTO() {
		
	}

	public EntregaDTO(String observaciones) {
		
		this.observaciones = observaciones;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
