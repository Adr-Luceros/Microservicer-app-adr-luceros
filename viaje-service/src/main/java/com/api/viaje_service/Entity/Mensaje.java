package com.api.viaje_service.Entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mensaje {
    private String mensaje;
    private List<String> observaciones;

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
