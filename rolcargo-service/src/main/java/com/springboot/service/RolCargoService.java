package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.RolCargo;
import com.springboot.repository.RolCargoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolCargoService {

	@Autowired
	RolCargoRepository rolCargoRepository;
	
	public List<RolCargo> listar(){
		return rolCargoRepository.findAll();
	}
	
	public Optional<RolCargo> getOne(int id){
		return rolCargoRepository.findById(id);
	}
	
	public void save(RolCargo rolCargo) {
		rolCargoRepository.save(rolCargo);
	}
	
	public void delete (int id) {
		rolCargoRepository.deleteById(id);
	}
}
