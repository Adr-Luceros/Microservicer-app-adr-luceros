package com.service.excel_service.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cargo_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "personal_id")
	private Personal personal;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rolcargo_id")
	private RolCargo rolCargo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "viaje_id")
	@JsonIgnore
	private Viaje viaje;

}
