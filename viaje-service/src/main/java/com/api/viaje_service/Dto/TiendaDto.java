package com.api.viaje_service.Dto;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TiendaDto {
    private String psEx;
    private String destinatario;
    private String tienda;
    private String distrito;
    private String direccion;
    private Time horaInicio;
    private Time horaFin;
    private float volumen;

    public static class Builder {
        private String psEx;
        private String destinatario;
        private String tienda;
        private String distrito;
        private String direccion;
        private Time horaInicio;
        private Time horaFin;
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

        public Builder horaInicio(Time horaInicio) {
            this.horaInicio = horaInicio;
            return this;
        }

        public Builder horaFin(Time horaFin) {
            this.horaFin = horaFin;
            return this;
        }

        public Builder volumen(float volumen) {
            this.volumen = volumen;
            return this;
        }

        public TiendaDto build() {
            return new TiendaDto(
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
