package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.TipoFlete;
import com.springboot.repository.TipoFleteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoFleteService {

	@Autowired
	TipoFleteRepository tipoFleteRepository;
	
	public List<TipoFlete> listar(){
		return tipoFleteRepository.findAll();
	}
	
	public Optional<TipoFlete> getOne(int id){
		return tipoFleteRepository.findById(id);
	}
	
	public void save(TipoFlete tipoFlete) {
		tipoFleteRepository.save(tipoFlete);
	}
	
	public void delete (int id) {
		tipoFleteRepository.deleteById(id);
	}
}
