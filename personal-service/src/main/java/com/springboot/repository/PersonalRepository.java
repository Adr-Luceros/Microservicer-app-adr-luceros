package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Integer>{

}
