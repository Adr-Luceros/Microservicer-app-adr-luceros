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

import com.springboot.dto.CamionDTO;
import com.springboot.entity.Camion;
import com.springboot.service.CamionService;

@RestController
@RequestMapping("/apicamion")
public class CamionController {

	@Autowired
	CamionService camionService;

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
	public ResponseEntity<List<Camion>> listar() {
		List<Camion> listaCamion = camionService.listar();
		return new ResponseEntity<List<Camion>>(listaCamion, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CamionDTO camionDTO) {
		Camion camion = new Camion(camionDTO.getMarca(),
				camionDTO.getPlaca(),
				camionDTO.getTc(),
				camionDTO.getSoat(),
				camionDTO.getCapacidad());

		camionService.save(camion);
		return new ResponseEntity<>("Camión agregado", HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody CamionDTO camionDTO) {
		Camion camion = camionService.getOne(id).get();
		camion.setMarca(camionDTO.getMarca());
		camion.setPlaca(camionDTO.getPlaca());
		camion.setTc(camionDTO.getTc());
		camion.setSoat(camionDTO.getSoat());
		camion.setCapacidad(camionDTO.getCapacidad());

		camionService.save(camion);
		return new ResponseEntity<>("Camión actualizado", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		camionService.delete(id);
		return new ResponseEntity<>("Camión eliminado", HttpStatus.OK);
	}
}
