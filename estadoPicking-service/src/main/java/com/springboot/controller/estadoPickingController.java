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

import com.springboot.dto.EstadoPickingDTO;
import com.springboot.entity.EstadoPicking;
import com.springboot.service.EstadoPickingService;

@RestController
@RequestMapping("/apiestadopicking")
public class estadoPickingController {

	@Autowired
	EstadoPickingService estadoPickingService;

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
	public ResponseEntity<List<EstadoPicking>> listar() {
		List<EstadoPicking> listaestadoPicking = estadoPickingService.listar();
		return new ResponseEntity<List<EstadoPicking>>(listaestadoPicking, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody EstadoPickingDTO estadoPickingDTO) {
		EstadoPicking estadoPicking = new EstadoPicking(estadoPickingDTO.getNombre());
		estadoPickingService.save(estadoPicking);
		return new ResponseEntity<>("EstadoPicking agregado", HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EstadoPickingDTO estadoPickingDTO) {
		EstadoPicking estadoPicking = estadoPickingService.getOne(id).get();
		estadoPicking.setNombre(estadoPickingDTO.getNombre());
		estadoPickingService.save(estadoPicking);
		return new ResponseEntity<>("EstadoPicking actualizado", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		estadoPickingService.delete(id);
		return new ResponseEntity<>("EstadoPicking eliminada", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstadoPicking> getEstadoPickingId(@PathVariable("id") int id) {
		Optional<EstadoPicking> optionalEstadoPicking = estadoPickingService.getOne(id);

		if (optionalEstadoPicking.isPresent()) {
			return ResponseEntity.ok(optionalEstadoPicking.get());
		} else {
			return ResponseEntity.status(404).body(null);
		}
	}

}
