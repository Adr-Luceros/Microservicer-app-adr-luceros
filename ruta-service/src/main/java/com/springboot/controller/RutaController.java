package com.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.springboot.dto.RutaDTO;
import com.springboot.entity.Ruta;
import com.springboot.service.RutaService;

@RestController
@RequestMapping("/apiruta")
public class RutaController {

	@Autowired
	RutaService rutaService;

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
	public ResponseEntity<List<Ruta>> listar() {
		List<Ruta> listaRuta = rutaService.listar();
		return new ResponseEntity<List<Ruta>>(listaRuta, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody RutaDTO rutaDTO) {
		Ruta ruta = new Ruta(rutaDTO.getNombre());

		rutaService.save(ruta);
		return new ResponseEntity<>("Ruta agregada", HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody RutaDTO rutaDTO) {
		Ruta ruta = rutaService.getOne(id).get();
		ruta.setNombre(rutaDTO.getNombre());

		rutaService.save(ruta);
		return new ResponseEntity<>("Ruta actualizada", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		rutaService.delete(id);
		return new ResponseEntity<>("Ruta eliminada", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ruta> getTiendaById(@PathVariable("id") int id) {
		Optional<Ruta> optionalRuta = rutaService.getOne(id);

		if (optionalRuta.isPresent()) {
			return ResponseEntity.ok(optionalRuta.get());
		} else {
			return ResponseEntity.status(404).body(null);
		}
	}
}
