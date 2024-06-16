package com.springboot.dto;

import com.springboot.entity.EstadoPicking;

public class PickingDTO {

	private Integer numeroPicking;
	private double volumen;
	
	private EstadoPicking estadoPicking;
	
	public PickingDTO(Integer numeroPicking, double volumen) {
		super();
		this.numeroPicking = numeroPicking;
		this.volumen = volumen;
		
	}

	public EstadoPicking getEstadoPicking() {
		return estadoPicking;
	}

	public void setEstadoPicking(EstadoPicking estadoPicking) {
		this.estadoPicking = estadoPicking;
	}

	public PickingDTO() {
		
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
