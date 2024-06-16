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

import com.springboot.dto.TipoFleteDTO;
import com.springboot.entity.TipoFlete;
import com.springboot.service.TipoFleteService;

@RestController
@RequestMapping("/apitipoflete")
public class TipoFleteController {

	@Autowired
	TipoFleteService tipoFleteService;

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
	public ResponseEntity<List<TipoFlete>> listar() {
		List<TipoFlete> listaTipoFlete = tipoFleteService.listar();
		return new ResponseEntity<List<TipoFlete>>(listaTipoFlete, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody TipoFleteDTO tipoFleteDTO) {
		TipoFlete tipoFlete = new TipoFlete(tipoFleteDTO.getNombre());

		tipoFleteService.save(tipoFlete);
		return new ResponseEntity<>("TipoFlete agregado", HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody TipoFleteDTO tipoFleteDTO) {
		TipoFlete tipoFlete = tipoFleteService.getOne(id).get();
		tipoFlete.setNombre(tipoFleteDTO.getNombre());

		tipoFleteService.save(tipoFlete);
		return new ResponseEntity<>("TipoFlete actualizado", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		tipoFleteService.delete(id);
		return new ResponseEntity<>("TipoFlete eliminado", HttpStatus.OK);
	}
}
