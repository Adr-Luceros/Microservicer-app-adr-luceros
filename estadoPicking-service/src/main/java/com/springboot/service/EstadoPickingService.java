package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.EstadoPicking;
import com.springboot.repository.EstadoPickingRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstadoPickingService {

	@Autowired
	EstadoPickingRepository estadoPickingRepository;
	
	public List<EstadoPicking> listar(){
		return estadoPickingRepository.findAll();
	}
	
	public Optional<EstadoPicking> getOne (int id){
		return estadoPickingRepository.findById(id);
	}
	
	public void save (EstadoPicking estadoPicking) {
		estadoPickingRepository.save(estadoPicking);
	}
	
	public void delete (int id) {
		estadoPickingRepository.deleteById(id);
	}
}
