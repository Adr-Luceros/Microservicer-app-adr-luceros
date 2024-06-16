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

import com.springboot.dto.FleteDTO;
import com.springboot.entity.Flete;
import com.springboot.service.FleteService;

@RestController
@RequestMapping("/apiflete")
public class FleteController {

	@Autowired
	FleteService fleteService;

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
	public ResponseEntity<List<Flete>> listar() {
		List<Flete> listaFlete = fleteService.listar();
		return new ResponseEntity<List<Flete>>(listaFlete, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody FleteDTO fleteDTO) {
		Flete flete = new Flete(fleteDTO.getVolumenViaje(),
				fleteDTO.getGuia(),
				fleteDTO.getPicking(),
				fleteDTO.getRuta(),
				fleteDTO.getTipoFlete(),
				fleteDTO.getViaje());

		fleteService.save(flete);
		return new ResponseEntity<>("Flete agregado", HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody FleteDTO fleteDTO) {
		Flete flete = fleteService.getOne(id).get();
		flete.setVolumenViaje(fleteDTO.getVolumenViaje());
		flete.setGuia(fleteDTO.getGuia());
		flete.setPicking(fleteDTO.getPicking());
		flete.setRuta(fleteDTO.getRuta());
		flete.setTipoFlete(fleteDTO.getTipoFlete());
		flete.setViaje(fleteDTO.getViaje());

		fleteService.save(flete);
		return new ResponseEntity<>("Flete actualizado", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		fleteService.delete(id);
		return new ResponseEntity<>("Flete eliminado", HttpStatus.OK);
	}
}
