package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dto.PickingDTO;
import com.springboot.entity.EstadoPicking;
import com.springboot.entity.Picking;
import com.springboot.repository.EstadoPickingClient;
import com.springboot.repository.PickingRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PickingService {

	@Autowired
	PickingRepository pickingRepository;
	
	/*
	@Autowired
	EstadoPickingClient estadoPickingClient;

	public PickingDTO getPickingWithEstadoPicking (Integer id) {
		Picking picking = pickingRepository.getById(id);
		EstadoPicking estadoPicking = estadoPickingClient.getEstadoPickingById(picking.getEstadopicking_id());
		return new PickingDTO(picking.getNumeroPicking(),
				              picking.getVolumen(),
				              estadoPicking);
		
	}
	*/
	
	public List<Picking> listar() {
		return pickingRepository.findAll();
	}

	public Optional<Picking> getOne(int id) {
		return pickingRepository.findById(id);
	}

	public void save(Picking picking) {
		pickingRepository.save(picking);
	}

	public void delete(int id) {
		pickingRepository.deleteById(id);
	}

}
