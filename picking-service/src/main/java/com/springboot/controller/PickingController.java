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

import com.springboot.dto.PickingDTO;
import com.springboot.entity.Picking;
import com.springboot.service.PickingService;

@RestController
@RequestMapping("/apipicking")
public class PickingController {

	@Autowired
	PickingService pickingService;

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
	public ResponseEntity<List<Picking>> listar() {
		List<Picking> listaPicking = pickingService.listar();
		return new ResponseEntity<List<Picking>>(listaPicking, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody PickingDTO pickingDTO) {
		Picking picking = new Picking(pickingDTO.getNumeroPicking(),
				                      pickingDTO.getVolumen(),
				                      pickingDTO.getEstadoPicking());
		pickingService.save(picking);
		return new ResponseEntity<>("Picking creado", HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PickingDTO pickingDTO) {
		Picking picking = pickingService.getOne(id).get();
		picking.setNumeroPicking(pickingDTO.getNumeroPicking());
		picking.setVolumen(pickingDTO.getVolumen());
		picking.setEstadoPicking(pickingDTO.getEstadoPicking());
		
		pickingService.save(picking);
		return new ResponseEntity<>("Picking actualiado", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		pickingService.delete(id);
		return new ResponseEntity<>("Picking eliminado", HttpStatus.OK);
	}
	/*
	@GetMapping("/{id}")
    public ResponseEntity<PickingDTO> getPickingWithEstadoPicking(@PathVariable("id") Integer id) {
        PickingDTO pickingDTO = pickingService.getPickingWithEstadoPicking(id);
        return ResponseEntity.ok(pickingDTO);
    }
    */
}
