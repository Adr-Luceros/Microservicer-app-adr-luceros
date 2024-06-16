package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Personal;
import com.springboot.repository.PersonalRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonalService {

	@Autowired
	PersonalRepository personalRepository;
	
	public List<Personal> listar(){
		return personalRepository.findAll();
	}
	
	public Optional<Personal> getOne (int id){
		return personalRepository.findById(id);
	}
	
	public void save (Personal personal) {
		personalRepository.save(personal);
	}
	public void delete (int id) {
		personalRepository.deleteById(id);
	}
}
