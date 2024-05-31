package com.api.viaje_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.viaje_service.Entity.Picking;

@Repository
public interface PickingRepository extends JpaRepository<Picking, Integer> {
    public Picking findByNroPicking(int nroPicking);
}
