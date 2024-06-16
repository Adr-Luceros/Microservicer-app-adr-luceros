package com.service.excel_service.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Viaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date fechaDeSalida;
    private String almacen;

    @ManyToOne
    @JoinColumn(name = "camion_id")
    private Camion camion;

    @OneToMany(mappedBy = "viaje")
    private List<Flete> fletes;

    @OneToMany(mappedBy = "viaje")
    private List<Entrega> entregas;

    public Viaje(Date fechaDeSalida, String almacen, Camion camion) {
        this.fechaDeSalida = fechaDeSalida;
        this.almacen = almacen;
        this.camion = camion;
    }
}
