package com.api.viaje_service.Entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Entrega implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "viaje_id")
    @JsonIgnore
    private Viaje viaje;

    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private Tienda tienda;

    public Entrega(Viaje viaje, Tienda tienda) {
        this.viaje = new Viaje();
        this.viaje.setId(viaje.getId());
        this.tienda = new Tienda();
        this.tienda.setId(tienda.getId());
    }

    // atributo estado de la entrega (puede y debe ser una entidad)
}
