package com.service.excel_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.excel_service.Entity.TipoFlete;

@Repository
public interface TipoFleteRepository extends JpaRepository<TipoFlete, Integer> {
    public TipoFlete findByNombreTipo(String nombreTipo);
}
