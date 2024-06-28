package com.springboot.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Flete;
import com.springboot.entity.FleteResponse;
import com.springboot.entity.Ruta;
import com.springboot.repository.FleteFeignClient;
import com.springboot.repository.RutaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RutaService {

	@Autowired
	RutaRepository rutaRepository;
	
	@Autowired
	FleteFeignClient fleteFeignClient;
	
	public List<Flete> getFletesByNombreRuta(String nombreRuta) {
	    return fleteFeignClient.getFletesByRutaNombre(nombreRuta);
	}
	
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
	public Ruta buscarPorNombre(String nombre) {
        return rutaRepository.findByNombre(nombre);
    }
}
