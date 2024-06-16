package com.springboot.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Picking {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer picking_id;
	private Integer numeroPicking;
	private double volumen;
	
	@OneToMany(mappedBy = "picking", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Flete> flete;
		
	public Picking() {
		
	}
	public Picking(Integer picking_id, Integer numeroPicking, double volumen) {
		
		this.picking_id = picking_id;
		this.numeroPicking = numeroPicking;
		this.volumen = volumen;
	}
	public List<Flete> getFlete() {
		return flete;
	}
	public void setFlete(List<Flete> flete) {
		this.flete = flete;
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
