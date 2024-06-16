package com.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.CapacidadDTO;
import com.springboot.entity.Capacidad;
import com.springboot.service.CapacidadService;

@RestController
@RequestMapping("/apicapacidad")
public class CapacidadController {

	@Autowired
	CapacidadService capacidadService;

	@Value("${message}")
	private String message;

	@Value("${global-message}")
	private String globalMessage;

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, String> message() {
		Map<String, String> response = new HashMap<>();
		response.put("message", message);
		response.put("global-message", globalMessage);
		return response;
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Capacidad>> listar() {
		List<Capacidad> listaCapacidad = capacidadService.listar();
		return new ResponseEntity<List<Capacidad>>(listaCapacidad, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CapacidadDTO capacidadDTO) {
		Capacidad capacidad = new Capacidad(capacidadDTO.getVolumen());

		capacidadService.save(capacidad);
		return new ResponseEntity<>("Capacidad agregada", HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody CapacidadDTO capacidadDTO) {
		Capacidad capacidad = capacidadService.getOne(id).get();
		capacidad.setVolumen(capacidadDTO.getVolumen());

		capacidadService.save(capacidad);
		return new ResponseEntity<>("Capacidad actualizada", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		capacidadService.delete(id);
		return new ResponseEntity<>("Capacidad eliminada", HttpStatus.OK);
	}
}
