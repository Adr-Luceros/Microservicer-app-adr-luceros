package com.springboot.dto;

import com.springboot.entity.Personal;
import com.springboot.entity.RolCargo;
import com.springboot.entity.Viaje;

public class CargoDTO {

	private Personal personal;

	private RolCargo rolCargo;
	
	private Viaje viaje;
	
	public CargoDTO() {
		
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public RolCargo getRolCargo() {
		return rolCargo;
	}

	public void setRolCargo(RolCargo rolCargo) {
		this.rolCargo = rolCargo;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	
	
}
