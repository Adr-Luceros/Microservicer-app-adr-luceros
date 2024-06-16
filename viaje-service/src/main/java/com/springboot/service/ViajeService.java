package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Viaje;
import com.springboot.repository.ViajeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ViajeService {

	@Autowired
	ViajeRepository viajeRepository;

	public List<Viaje> listar() {
		return viajeRepository.findAll();
	}

	public Optional<Viaje> getOne(int id) {
		return viajeRepository.findById(id);
	}

	public void save(Viaje viaje) {
		viajeRepository.save(viaje);
	}

	public void delete(int id) {
		viajeRepository.deleteById(id);
	}
}
