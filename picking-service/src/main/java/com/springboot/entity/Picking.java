package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Picking {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer picking_id;
	private Integer numeroPicking;
	private double volumen;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estadopicking_id")
	private EstadoPicking estadoPicking;
	
	public Picking() {
		
	}

	public Picking(Integer numeroPicking, double volumen, EstadoPicking estadoPicking) {
		super();
		this.numeroPicking = numeroPicking;
		this.volumen = volumen;
		this.estadoPicking = estadoPicking;
	}

	public EstadoPicking getEstadoPicking() {
		return estadoPicking;
	}

	public void setEstadoPicking(EstadoPicking estadoPicking) {
		this.estadoPicking = estadoPicking;
	}

	public Integer getPicking_id() {
		return picking_id;
	}
	public void setPicking_id(Integer picking_id) {
		this.picking_id = picking_id;
	}
	public Integer getNumeroPicking() {
		return numeroPicking;
	}
	public void setNumeroPicking(Integer numeroPicking) {
		this.numeroPicking = numeroPicking;
	}
	public double getVolumen() {
		return volumen;
	}
	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}
	
	
}
