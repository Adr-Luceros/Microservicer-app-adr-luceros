package com.service.excel_service.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Picking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "picking_id")
    private int id;
    @Column(name = "numero_picking")
    private int nroPicking;
    private Date fechaCreacion;
    private double volumen;

    @OneToMany(mappedBy = "picking")
    @JsonIgnore
    private List<Flete> fletes;

    public Picking(int nroPicking, Date fechaCreacion) {
        this.nroPicking = nroPicking;
        this.fechaCreacion = fechaCreacion;
    }
}
