package com.api.viaje_service.Dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private String psEx;
    private String destinatario;
    private String tienda;
    private String distrito;
    private String direccion;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private float volumen;

    public static class Builder {
        private String psEx;
        private String destinatario;
        private String tienda;
        private String distrito;
        private String direccion;
        private LocalTime horaInicio;
        private LocalTime horaFin;
        private float volumen;

        public Builder() {
        }

        public Builder psEx(String psEx) {
            this.psEx = psEx;
            return this;
        }

        public Builder destinatario(String destinatario) {
            this.destinatario = destinatario;
            return this;
        }

        public Builder tienda(String tienda) {
            this.tienda = tienda;
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

        public Builder horaInicio(LocalTime horaInicio) {
            this.horaInicio = horaInicio;
            return this;
        }

        public Builder horaFin(LocalTime horaFin) {
            this.horaFin = horaFin;
            return this;
        }

        public Builder volumen(float volumen) {
            this.volumen = volumen;
            return this;
        }

        public Cliente build() {
            return new Cliente(
                    psEx,
                    destinatario,
                    tienda,
                    distrito,
                    direccion,
                    horaInicio,
                    horaFin,
                    volumen);
        }
    }
}
