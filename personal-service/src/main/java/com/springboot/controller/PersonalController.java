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

import com.springboot.dto.PersonalDTO;
import com.springboot.entity.Personal;
import com.springboot.service.PersonalService;

@RestController
@RequestMapping("/apipersonal")
public class PersonalController {

	@Autowired
	PersonalService personalService;

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
	public ResponseEntity<List<Personal>> listar() {
		List<Personal> listaPersonal = personalService.listar();
		return new ResponseEntity<List<Personal>>(listaPersonal, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody PersonalDTO personalDTO) {
		Personal personal = new Personal(personalDTO.getNombre(),
				personalDTO.getTelefono(),
				personalDTO.getNroDocumento(),
				personalDTO.getTipoDocumento());
		personalService.save(personal);
		return new ResponseEntity<>("Personal agregado", HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PersonalDTO personalDTO) {
		Personal personal = personalService.getOne(id).get();
		personal.setNombre(personalDTO.getNombre());
		personal.setTelefono(personalDTO.getTelefono());
		personal.setNroDocumento(personalDTO.getNroDocumento());
		personal.setTipoDocumento(personalDTO.getTipoDocumento());
		personalService.save(personal);
		return new ResponseEntity<>("Personal actualizado", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		personalService.delete(id);
		return new ResponseEntity<>("Personal eliminado", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Personal> getPersonalById(@PathVariable("id") int id) {
		Optional<Personal> optionalPersonal = personalService.getOne(id);

		if (optionalPersonal.isPresent()) {
			return ResponseEntity.ok(optionalPersonal.get());
		} else {
			return ResponseEntity.status(404).body(null);
		}
	}
}
