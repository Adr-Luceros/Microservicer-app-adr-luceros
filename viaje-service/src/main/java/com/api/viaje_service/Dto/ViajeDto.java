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
public class ViajeDto {
    private String placa;
    private List<Integer> picking;
    private String almacen;
    private List<TiendaDto> clientes;

    public static class Builder {
        private String placa;
        private List<Integer> picking;
        private String almacen;
        private List<TiendaDto> clientes;

        public Builder placa(String placa) {
            this.placa = placa;
            return this;
        }

        public Builder picking(List<Integer> picking) {
            this.picking = picking;
            return this;
        }

        public Builder picking(Integer picking) {
            this.picking.add(picking);
            return this;
        }

        public Builder almacen(String almacen) {
            this.almacen = almacen;
            return this;
        }

        public Builder clientes(List<TiendaDto> clientes) {
            this.clientes = clientes;
            return this;
        }

        public Builder clientes(TiendaDto cliente) {
            this.clientes.add(cliente);
            return this;
        }

        public ViajeDto build() {
            return new ViajeDto(placa, picking, almacen, clientes);
        }
    }
}
