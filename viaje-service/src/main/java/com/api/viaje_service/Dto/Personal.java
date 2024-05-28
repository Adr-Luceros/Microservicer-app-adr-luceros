package com.api.viaje_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Personal {
    private String nombre;
    private String documento;
    private String nroDocumento;
    private int nroTelefono;
}
