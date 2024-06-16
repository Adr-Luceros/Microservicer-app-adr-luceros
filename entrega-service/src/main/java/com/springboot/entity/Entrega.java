package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Entrega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entrega_id;
	private String observaciones;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estadoentrega_id")
	private EstadoEntrega estadoEntrega;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tienda_id")
	private Tienda tienda;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "viaje_id")
	private Viaje viaje;
	
	public Entrega(String observaciones, EstadoEntrega estadoEntrega, Tienda tienda, Viaje viaje) {
		
		this.observaciones = observaciones;
		this.estadoEntrega = estadoEntrega;
		this.tienda = tienda;
		this.viaje = viaje;
	}

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

	public Entrega() {
		
	}
	
	public Integer getEntrega_id() {
		return entrega_id;
	}
	public void setEntrega_id(Integer entrega_id) {
		this.entrega_id = entrega_id;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
