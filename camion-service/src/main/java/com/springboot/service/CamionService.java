package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Camion;
import com.springboot.repository.CamionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CamionService {

	@Autowired
	CamionRepository camionRepository;
	
	public List<Camion> listar(){
		return camionRepository.findAll();
	}
	public Optional<Camion> getOne (int id){
		return camionRepository.findById(id);
	}
	public void save (Camion camion) {
		camionRepository.save(camion);
	}
	public void delete (int id) {
		camionRepository.deleteById(id);
	}
}
