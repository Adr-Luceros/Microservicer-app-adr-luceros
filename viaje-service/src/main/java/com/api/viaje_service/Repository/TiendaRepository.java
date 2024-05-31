package com.api.viaje_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.viaje_service.Entity.Tienda;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Integer> {
    public Tienda findByDestinatarioAndNombreTienda(String destinatario, String nombreTienda);
}
