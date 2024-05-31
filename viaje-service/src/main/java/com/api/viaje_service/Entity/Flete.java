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
public class Flete implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "picking_id")
    private Picking picking;

    @ManyToOne
    @JoinColumn(name = "viaje_id")
    @JsonIgnore
    private Viaje viaje;

    @ManyToOne
    @JoinColumn(name = "tipo_flete_id")
    private TipoFlete tipo;

    public Flete(Picking picking, Viaje viaje, TipoFlete tipo) {
        this.picking = new Picking();
        this.picking.setId(picking.getId());
        this.viaje = new Viaje();
        this.viaje.setId(viaje.getId());
        this.tipo = new TipoFlete();
        this.tipo.setId(tipo.getId());
    }

    // atributo estado de la entrega (puede y debe ser una entidad)
}
