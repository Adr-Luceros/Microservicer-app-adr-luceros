package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Camion;

public interface CamionRepository extends JpaRepository<Camion, Integer>{

}
