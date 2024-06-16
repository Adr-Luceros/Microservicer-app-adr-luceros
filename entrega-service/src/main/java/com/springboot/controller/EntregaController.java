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

import com.springboot.dto.EntregaDTO;
import com.springboot.entity.Entrega;
import com.springboot.service.EntregaService;

@RestController
@RequestMapping("/apientrega")
public class EntregaController {

	@Autowired
	EntregaService entregaService;

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
	public ResponseEntity<List<Entrega>> listar() {
		List<Entrega> listaEntrega = entregaService.listar();
		return new ResponseEntity<List<Entrega>>(listaEntrega, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody EntregaDTO entregaDTO) {
		Entrega entrega = new Entrega(entregaDTO.getObservaciones(),
				entregaDTO.getEstadoEntrega(),
				entregaDTO.getTienda(),
				entregaDTO.getViaje());

		entregaService.save(entrega);
		return new ResponseEntity<>("Entrega agregada", HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EntregaDTO entregaDTO) {
		Entrega entrega = entregaService.getOne(id).get();
		entrega.setObservaciones(entregaDTO.getObservaciones());
		entrega.setEstadoEntrega(entregaDTO.getEstadoEntrega());
		entrega.setTienda(entregaDTO.getTienda());
		entrega.setViaje(entregaDTO.getViaje());

		entregaService.save(entrega);
		return new ResponseEntity<>("Entrega actualizada", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		entregaService.delete(id);
		return new ResponseEntity<>("Entrega eliminada", HttpStatus.OK);
	}
}
