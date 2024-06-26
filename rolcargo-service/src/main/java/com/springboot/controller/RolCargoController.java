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

import com.springboot.dto.RolCargoDTO;
import com.springboot.entity.RolCargo;
import com.springboot.service.RolCargoService;

@RestController
@RequestMapping("/apirolcargo")
public class RolCargoController {

	@Autowired
	RolCargoService rolCargoService;

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
	public ResponseEntity<List<RolCargo>> listar() {
		List<RolCargo> listaRolCargo = rolCargoService.listar();
		return new ResponseEntity<List<RolCargo>>(listaRolCargo, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody RolCargoDTO rolCargoDTO) {
		RolCargo rolCargo = new RolCargo(rolCargoDTO.getNombre());

		rolCargoService.save(rolCargo);
		return new ResponseEntity<>("RolCargo agregado", HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody RolCargoDTO rolCargoDTO) {
		RolCargo rolCargo = rolCargoService.getOne(id).get();
		rolCargo.setNombre(rolCargoDTO.getNombre());

		rolCargoService.save(rolCargo);
		return new ResponseEntity<>("RolCargo actualizado", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		rolCargoService.delete(id);
		return new ResponseEntity<>("RolCargo eliminado", HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<RolCargo> getEstadoPickingId(@PathVariable("id") int id) {
		Optional<RolCargo> optionalRolCargo = rolCargoService.getOne(id);

		if (optionalRolCargo.isPresent()) {
			return ResponseEntity.ok(optionalRolCargo.get());
		} else {
			return ResponseEntity.status(404).body(null);
		}
	}
}
