package com.service.excel_service.Dto;

import java.sql.Time;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecepcionData {
    private String ruc;
    private String razonSocial;
    private String placa;
    private List<Integer> picking;
    private String almacen;
    private String psEx;
    private String destinatario;
    private String tienda;
    private String distrito;
    private String direccion;
    private Time horaInicio;
    private Time horaFinal;
    private String documentacion;
    private String observaciones;
    private String canal;
    private float volumen;
}
