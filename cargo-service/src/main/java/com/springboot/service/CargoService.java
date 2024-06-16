package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Cargo;
import com.springboot.repository.CargoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CargoService {

	@Autowired
	CargoRepository cargoRepository;
	
	public List<Cargo> listar(){
		return cargoRepository.findAll();
	}
	public Optional<Cargo> getOne (int id){
		return cargoRepository.findById(id);
	}
	public void save (Cargo cargo) {
		cargoRepository.save(cargo);
	}
	public void delete (int id) {
		cargoRepository.deleteById(id);
	}
}
