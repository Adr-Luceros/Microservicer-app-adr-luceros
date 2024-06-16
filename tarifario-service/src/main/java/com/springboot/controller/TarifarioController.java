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

import com.springboot.dto.TarifarioDTO;
import com.springboot.entity.Tarifario;
import com.springboot.service.TarifarioService;

@RestController
@RequestMapping("/apitarifario")
public class TarifarioController {

	@Autowired
	TarifarioService tarifarioService;

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
	public ResponseEntity<List<Tarifario>> listar() {
		List<Tarifario> listaTarifario = tarifarioService.listar();
		return new ResponseEntity<List<Tarifario>>(listaTarifario, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody TarifarioDTO tarifarioDTO) {
		Tarifario tarifario = new Tarifario(tarifarioDTO.getCapacidad(),
				tarifarioDTO.getRuta(),
				tarifarioDTO.getTipoFlete());
		tarifarioService.save(tarifario);
		return new ResponseEntity<>("Tarifario agregado", HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody TarifarioDTO tarifarioDTO) {
		Tarifario tarifario = tarifarioService.getOne(id).get();
		tarifario.setCapacidad(tarifarioDTO.getCapacidad());
		tarifario.setRuta(tarifarioDTO.getRuta());
		tarifario.setTipoFlete(tarifarioDTO.getTipoFlete());

		tarifarioService.save(tarifario);
		return new ResponseEntity<>("Tarifario actualizado", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		tarifarioService.delete(id);
		return new ResponseEntity<>("Tarifario eliminado", HttpStatus.OK);
	}
}
