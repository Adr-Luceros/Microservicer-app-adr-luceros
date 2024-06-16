package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Tarifario;
import com.springboot.repository.TarifarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TarifarioService {

	@Autowired
	TarifarioRepository tarifarioRepository;
	
	public List<Tarifario> listar() {
		return tarifarioRepository.findAll();
	}

	public Optional<Tarifario> getOne(int id) {
		return tarifarioRepository.findById(id);
	}

	public void save(Tarifario tarifario) {
		tarifarioRepository.save(tarifario);
	}

	public void delete(int id) {
		tarifarioRepository.deleteById(id);
	}
}
