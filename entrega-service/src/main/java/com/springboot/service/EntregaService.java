package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Entrega;
import com.springboot.repository.EntregaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EntregaService {

	@Autowired
	EntregaRepository entregaRepository;
	
	public List<Entrega> listar(){
		return entregaRepository.findAll();
	}
	public Optional<Entrega> getOne (int id){
		return entregaRepository.findById(id);
	}
	public void save (Entrega entrega) {
		entregaRepository.save(entrega);
	}
	public void delete (int id) {
		entregaRepository.deleteById(id);
	}
}
