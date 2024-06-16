package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Tienda;
import com.springboot.repository.TiendaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TiendaService {

	@Autowired
	TiendaRepository tiendaRepository;
	
	public List<Tienda> listar(){
		return tiendaRepository.findAll();
	}
	
	public Optional<Tienda> getOne(int id){
		return tiendaRepository.findById(id);
	}
	
	public void save(Tienda tienda) {
		tiendaRepository.save(tienda);
	}
	
	public void delete (int id) {
		tiendaRepository.deleteById(id);
	}
}
