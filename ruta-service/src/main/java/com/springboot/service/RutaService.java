package com.springboot.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Ruta;
import com.springboot.repository.RutaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RutaService {

	@Autowired
	RutaRepository rutaRepository;
	
	public List<Ruta> listar(){
		return rutaRepository.findAll();
	}
	public Optional<Ruta> getOne(int id){
		return rutaRepository.findById(id);
	}
	public void save(Ruta ruta) {
		rutaRepository.save(ruta);
	}
	public void delete(int id) {
		rutaRepository.deleteById(id);
	}
}
