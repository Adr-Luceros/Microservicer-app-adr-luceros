package com.api.viaje_service.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.viaje_service.Entity.Viaje;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer> {
    @Query("SELECT v FROM Viaje v WHERE DATE(v.fechaDeSalida) = DATE(:hoy)")
    List<Viaje> findByFechaDeSalidaHoy(@Param("hoy") Date hoy);
}
