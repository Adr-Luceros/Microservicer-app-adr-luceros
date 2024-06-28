package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Flete;
import com.springboot.repository.FleteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FleteService {

	@Autowired
	FleteRepository fleteRepository;
	
	public List<Flete> listar() {
		return fleteRepository.findAll();
	}

	public Optional<Flete> getOne(int id) {
		return fleteRepository.findById(id);
	}

	public void save(Flete flete) {
		fleteRepository.save(flete);
	}

	public void delete(int id) {
		fleteRepository.deleteById(id);
	}
	public List<Flete> getFletesByNombreRuta(String nombreRuta) {
        // Implementa la lógica para buscar fletes por nombre de ruta
        return fleteRepository.findByRutaNombre(nombreRuta);
    }
}
