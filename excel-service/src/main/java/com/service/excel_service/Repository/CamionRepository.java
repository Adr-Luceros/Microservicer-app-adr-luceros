package com.service.excel_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.excel_service.Entity.Camion;

@Repository
public interface CamionRepository extends JpaRepository<Camion, Integer> {
    public Camion findByPlaca(String placa);
}
