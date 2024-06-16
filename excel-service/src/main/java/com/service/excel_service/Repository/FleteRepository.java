
package com.service.excel_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.excel_service.Entity.Flete;

@Repository
public interface FleteRepository extends JpaRepository<Flete, Integer> {
    @Query(value = "SELECT * FROM flete WHERE picking_id = ?1 AND viaje_id = ?2 AND tipo_flete_id = ?3", nativeQuery = true)
    public Flete findByPickingAndViajeAndTipoSQL(int pickingId, int viajeId, int tipoId);
}
