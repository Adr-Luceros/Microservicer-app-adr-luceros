package com.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.entity.Picking;
import com.springboot.repository.PickingRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PickingService {

	@Autowired
	PickingRepository pickingRepository;
		
	public List<Picking> listar(){
		return pickingRepository.findAll();
	}
	
	/*
	public List<ResponseDTO> listar(){
		List<ResponseDTO> responseDTOList = new ArrayList<>();
		
		List<Picking> pickings = pickingRepository.findAll();
		
		for(Picking picking : pickings) {
			ResponseDTO responseDTO = new ResponseDTO();
			
			ResponseEntity<EstadoPickingDTO> responseEntity = restTemplate.getForEntity("http://localhost:8852/apiestadopicking/" + picking.getEstadopicking_id(), EstadoPickingDTO.class);
		
			EstadoPickingDTO estadoPickingDTO = responseEntity.getBody();
			
			responseDTO.setPicking(picking);
			responseDTO.setEstadoPickingDTO(estadoPickingDTO);
			
			responseDTOList.add(responseDTO);
		}
		return responseDTOList;
	}
	*/
	
	public Optional<Picking> getOne(int id){
		return pickingRepository.findById(id);
	}
	
	public void save (Picking picking) {
		pickingRepository.save(picking);
	}
	
	public void delete (int id) {
		pickingRepository.deleteById(id);
	}
	
	/*
	public ResponseDTO getPickingById(int id) {
		ResponseDTO responseDTO = new ResponseDTO();
		
		Picking picking = new Picking();
		picking = pickingRepository.findById(id).get();
		
		ResponseEntity<EstadoPickingDTO> responseEntity = restTemplate.getForEntity("http://localhost:8852/apiestadopicking/" + picking.getEstadopicking_id(), EstadoPickingDTO.class);
		
		EstadoPickingDTO estadoPickingDTO = responseEntity.getBody();
		
		responseDTO.setPicking(picking);
		responseDTO.setEstadoPickingDTO(estadoPickingDTO);
		
		return responseDTO;
	}
	*/
}
