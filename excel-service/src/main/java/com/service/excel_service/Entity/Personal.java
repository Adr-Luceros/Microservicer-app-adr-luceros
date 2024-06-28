package com.service.excel_service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personal {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer personal_id;
	private String nombre;
	private String telefono;
	private String nroDocumento;
	private String tipoDocumento;
}
