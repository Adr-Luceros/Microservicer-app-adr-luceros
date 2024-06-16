package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Capacidad;
import com.springboot.repository.CapacidadRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CapacidadService {

	@Autowired
	CapacidadRepository capacidadRepository;
	
	public List<Capacidad> listar(){
		return capacidadRepository.findAll();
	}
	public Optional<Capacidad> getOne (int id){
		return capacidadRepository.findById(id);
	}
	public void save (Capacidad capacidad) {
		capacidadRepository.save(capacidad);
	}
	public void delete (int id) {
		capacidadRepository.deleteById(id);
	}
}
