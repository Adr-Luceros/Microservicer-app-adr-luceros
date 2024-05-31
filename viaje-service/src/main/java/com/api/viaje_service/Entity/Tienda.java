package com.api.viaje_service.Entity;

import java.io.Serializable;

import java.sql.Time;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Tienda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String psEx;
    private String destinatario;
    private String nombreTienda;
    private String distrito;
    private String direccion;
    private Time horaInicio;
    private Time horaFin;

    @OneToMany(mappedBy = "tienda")
    @JsonIgnore
    private List<Entrega> entregas;

    public static class Builder {
        private int id;
        private String psEx;
        private String destinatario;
        private String nombreTienda;
        private String distrito;
        private String direccion;
        private Time horaInicio;
        private Time horaFin;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder psEx(String psEx) {
            this.psEx = psEx;
            return this;
        }

        public Builder destinatario(String destinatario) {
            this.destinatario = destinatario;
            return this;
        }

        public Builder nombreTienda(String nombreTienda) {
            this.nombreTienda = nombreTienda;
            return this;
        }

        public Builder distrito(String distrito) {
            this.distrito = distrito;
            return this;
        }

        public Builder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder horaInicio(Time horaInicio) {
            this.horaInicio = horaInicio;
            return this;
        }

        public Builder horaFin(Time horaFin) {
            this.horaFin = horaFin;
            return this;
        }

        public Tienda build() {
            return new Tienda(id, psEx, destinatario, nombreTienda, distrito, direccion, horaInicio, horaFin, null);
        }
    }
}
