package com.api.viaje_service.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Viaje {
    private String placa;
    private List<Integer> picking;
    private String almacen;
    private float volumnenTotal;
    private Personal chofer;
    private List<Personal> estibas;
    private List<Cliente> clientes;

    public static class Builder {
        private String placa;
        private List<Integer> picking;
        private String almacen;
        private float volumnenTotal;
        private Personal chofer;
        private List<Personal> estibas;
        private List<Cliente> clientes;

        public Builder setPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public Builder setPicking(List<Integer> picking) {
            this.picking = picking;
            return this;
        }

        public Builder setPicking(Integer picking) {
            this.picking.add(picking);
            return this;
        }

        public Builder setAlmacen(String almacen) {
            this.almacen = almacen;
            return this;
        }

        public Builder setVolumnenTotal(float volumnenTotal) {
            this.volumnenTotal = volumnenTotal;
            return this;
        }

        public Builder setChofer(Personal chofer) {
            this.chofer = chofer;
            return this;
        }

        public Builder setEstibas(List<Personal> estibas) {
            this.estibas = estibas;
            return this;
        }

        public Builder setEstibas(Personal estiba) {
            this.estibas.add(estiba);
            return this;
        }

        public Builder setClientes(List<Cliente> clientes) {
            this.clientes = clientes;
            return this;
        }

        public Builder setClientes(Cliente cliente) {
            this.clientes.add(cliente);
            return this;
        }

        public Viaje build() {
            return new Viaje(placa, picking, almacen, volumnenTotal, chofer, estibas, clientes);
        }
    }
}
