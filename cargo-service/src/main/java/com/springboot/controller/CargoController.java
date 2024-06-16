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

import com.springboot.dto.CargoDTO;
import com.springboot.entity.Cargo;
import com.springboot.service.CargoService;

@RestController
@RequestMapping("/apicargo")
public class CargoController {

	@Autowired
	CargoService cargoService;
	
	@Value("${message}")
	private String message;
	
	@Value("${global-message}")
	private String globalMessage;
	
	@RequestMapping(method = RequestMethod.GET)
	public Map<String, String> message(){		
		Map<String, String> response = new HashMap<>();
		response.put("message", message);
		response.put("global-message", globalMessage);
		return response;
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Cargo>> listar(){
		List<Cargo> listaCargo = cargoService.listar();
		return new ResponseEntity<List<Cargo>> (listaCargo, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create (@RequestBody CargoDTO cargoDTO){
		Cargo cargo = new Cargo(cargoDTO.getPersonal(),
				                cargoDTO.getRolCargo(),
				                cargoDTO.getViaje());
		
		cargoService.save(cargo);
		return new ResponseEntity("Cargo agregado", HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable ("id") int id, @RequestBody CargoDTO cargoDTO){
		Cargo cargo = cargoService.getOne(id).get();
		cargo.setPersonal(cargoDTO.getPersonal());
		cargo.setRolCargo(cargoDTO.getRolCargo());
		cargo.setViaje(cargoDTO.getViaje());
			
		cargoService.save(cargo);
		return new ResponseEntity("Cargo actualizado", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable ("id") int id){
		cargoService.delete(id);
		return new ResponseEntity("Cargo eliminado", HttpStatus.OK);
	}
}
