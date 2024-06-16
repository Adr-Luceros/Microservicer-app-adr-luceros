package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Picking;

public interface PickingRepository extends JpaRepository<Picking, Integer>{

}
