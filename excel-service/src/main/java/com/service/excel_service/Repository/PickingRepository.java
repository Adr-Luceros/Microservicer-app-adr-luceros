package com.service.excel_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.excel_service.Entity.Picking;

@Repository
public interface PickingRepository extends JpaRepository<Picking, Integer> {
    public Picking findByNroPicking(int nroPicking);
}
