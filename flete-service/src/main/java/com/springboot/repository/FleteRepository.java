package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Flete;

public interface FleteRepository extends JpaRepository<Flete, Integer>{

	// Método para buscar fletes por nombre de ruta
    List<Flete> findByRutaNombre(String nombreRuta);
}
