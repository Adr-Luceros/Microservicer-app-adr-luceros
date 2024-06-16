package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.EstadoEntrega;
import com.springboot.repository.EstadoEntregaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstadoEntregaService {

	@Autowired
	EstadoEntregaRepository estadoEntregaRepository;
	
	public List<EstadoEntrega> listar(){
		return estadoEntregaRepository.findAll();
	}
	public Optional<EstadoEntrega> getOne (int id){
		return estadoEntregaRepository.findById(id);
	}
	public void save (EstadoEntrega estadoEntrega) {
		estadoEntregaRepository.save(estadoEntrega);
	}
	public void delete (int id) {
		estadoEntregaRepository.deleteById(id);
	}
}
