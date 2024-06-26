package com.service.excel_service.Entity;

import java.io.Serializable;
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
public class TipoFlete implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipoflete_id")
    private int id;
    @Column(name = "nombre")
    private String nombreTipo;

    @OneToMany(mappedBy = "tipo")
    @JsonIgnore
    private List<Flete> fletes;

    public TipoFlete(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}
