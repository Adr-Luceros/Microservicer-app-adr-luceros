package com.service.excel_service.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.excel_service.Dto.TiendaDto;
import com.service.excel_service.Dto.ViajeDto;
import com.service.excel_service.Entity.Camion;
import com.service.excel_service.Entity.Entrega;
import com.service.excel_service.Entity.Flete;
import com.service.excel_service.Entity.Picking;
import com.service.excel_service.Entity.Tienda;
import com.service.excel_service.Entity.TipoFlete;
import com.service.excel_service.Entity.Viaje;
import com.service.excel_service.Repository.CamionRepository;
import com.service.excel_service.Repository.EntregaRepository;
import com.service.excel_service.Repository.FleteRepository;
import com.service.excel_service.Repository.PickingRepository;
import com.service.excel_service.Repository.TiendaRepository;
import com.service.excel_service.Repository.TipoFleteRepository;
import com.service.excel_service.Repository.ViajeRepository;

@Service
public class AlmacenarDatosService {

    @Autowired
    CamionRepository camionRepository;

    @Autowired
    ViajeRepository viajeRepository;

    @Autowired
    PickingRepository pickingRepository;

    @Autowired
    FleteRepository fleteRepository;

    @Autowired
    TipoFleteRepository tipoFleteRepository;

    @Autowired
    TiendaRepository tiendaRepository;

    @Autowired
    EntregaRepository entregaRepository;

    public void almacenar(List<ViajeDto> viajes) {

        for (ViajeDto viaje : viajes) {
            // Date hoy = Date.from(Instant.now());
            LocalDate localDate = LocalDate.now(ZoneId.systemDefault());
            Date hoy = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            Camion camion = camionRepository.findByPlaca(viaje.getPlaca());
            if (camion == null) {
                camion = new Camion(viaje.getPlaca());
                camion = camionRepository.save(camion);
            }
            Viaje viajeGuardado = new Viaje(hoy, viaje.getAlmacen(), camion);
            viajeGuardado = viajeRepository.save(viajeGuardado);

            for (int nroPicking : viaje.getPicking()) {
                // guardar picking
                Picking p = pickingRepository.findByNroPicking(nroPicking);
                if (p == null) {
                    p = new Picking(nroPicking, hoy);
                    p = pickingRepository.save(p);
                }
                // guardar tipo de flete
                String tipo = "Tipo A";
                TipoFlete tipoFlete = tipoFleteRepository.findByNombreTipo(tipo);
                if (tipoFlete == null) {
                    tipoFlete = new TipoFlete(tipo);
                    tipoFlete = tipoFleteRepository.save(tipoFlete);
                }
                // guardar fletes
                Flete flete = fleteRepository.findByPickingAndViajeAndTipoSQL(p.getId(), viajeGuardado.getId(),
                        tipoFlete.getId());
                if (flete == null) {
                    flete = new Flete(p, viajeGuardado, tipoFlete);
                    flete = fleteRepository.save(flete);
                }
            }

            for (TiendaDto tienda : viaje.getClientes()) {
                // guardar tiendas
                Tienda t = tiendaRepository.findByDestinatarioAndNombreTienda(tienda.getDestinatario(),
                        tienda.getTienda());
                if (t == null) {
                    t = new Tienda.Builder()
                            .psEx(tienda.getPsEx())
                            .destinatario(tienda.getDestinatario())
                            .nombreTienda(tienda.getTienda())
                            .distrito(tienda.getDistrito())
                            .direccion(tienda.getDireccion())
                            .horaInicio(tienda.getHoraInicio())
                            .horaFin(tienda.getHoraFin())
                            .build();
                    t = tiendaRepository.save(t);
                }
                // guardar entregas
                Entrega entrega = entregaRepository.findByTiendaAndViaje(t.getId(), viajeGuardado.getId());
                if (entrega == null) {
                    entrega = new Entrega(viajeGuardado, t);
                    entrega = entregaRepository.save(entrega);
                }
            }
        }
    }

    public List<Viaje> getAllViajesHoy() {
        LocalDate localDate = LocalDate.now();
        Date hoy = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return viajeRepository.findByFechaDeSalidaHoy(hoy);
    }
}
