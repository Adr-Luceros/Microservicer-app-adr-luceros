package com.service.excel_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.excel_service.Entity.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {
    @Query(value = "SELECT * FROM entrega WHERE tienda_id = ?1 AND viaje_id = ?2", nativeQuery = true)
    public Entrega findByTiendaAndViaje(int tiendaId, int viajeId);
}
