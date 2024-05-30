package com.api.viaje_service.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.viaje_service.Dto.RecepcionData;
import com.api.viaje_service.Dto.TiendaDto;
import com.api.viaje_service.Dto.ViajeDto;

@Service
public class AgruparService {
    public List<ViajeDto> agrupar(List<RecepcionData> data) {
        List<ViajeDto> viajes = new ArrayList<ViajeDto>();
        for (RecepcionData entrega : data) {
            ViajeDto viaje = null;
            for (ViajeDto v : viajes) {
                if (v.getPlaca().equals(entrega.getPlaca())) {
                    viaje = v;
                    break;
                }
                ;
            }

            TiendaDto tienda = new TiendaDto.Builder()
                    .psEx(entrega.getPsEx())
                    .destinatario(entrega.getDestinatario())
                    .tienda(entrega.getTienda())
                    .distrito(entrega.getDistrito())
                    .direccion(entrega.getDireccion())
                    .horaInicio(entrega.getHoraInicio())
                    .horaFin(entrega.getHoraFinal())
                    .volumen(entrega.getVolumen())
                    .build();

            if (viaje == null) {
                viaje = new ViajeDto.Builder()
                        .placa(entrega.getPlaca())
                        .almacen(entrega.getAlmacen())
                        .picking(entrega.getPicking())
                        .build();
                viajes.add(viaje);
            }
            List<TiendaDto> tiendas = viaje.getClientes();
            if (tiendas == null) {
                tiendas = new ArrayList<TiendaDto>();
            }
            tiendas.add(tienda);
            viaje.setClientes(tiendas);
        }
        return viajes;
    }
}
