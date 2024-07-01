package com.service.excel_service.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class EstadoEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer estadoentrega_id;
    private String nombre;

    @OneToMany(mappedBy = "estadoEntrega", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Entrega> entrega;
}
