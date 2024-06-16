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

import com.springboot.dto.ViajeDTO;
import com.springboot.entity.Viaje;
import com.springboot.service.ViajeService;

@RestController
@RequestMapping("/apiviaje")
public class ViajeController {

	@Autowired
	ViajeService viajeService;
	
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
	public ResponseEntity<List<Viaje>> listar(){
		List<Viaje> listaViaje = viajeService.listar();
		return new ResponseEntity<List<Viaje>> (listaViaje, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create (@RequestBody ViajeDTO viajeDTO){
		Viaje viaje = new Viaje(viajeDTO.getFechaSalida(),
				                viajeDTO.getAlmacen(),
				                viajeDTO.getCamion());
		
		viajeService.save(viaje);
		return new ResponseEntity("Viaje agregado", HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable ("id") int id, @RequestBody ViajeDTO viajeDTO){
		Viaje viaje = viajeService.getOne(id).get();
		viaje.setFechaSalida(viajeDTO.getFechaSalida());
		viaje.setAlmacen(viajeDTO.getAlmacen());
		viaje.setCamion(viajeDTO.getCamion());
		
		viajeService.save(viaje);
		return new ResponseEntity("Viaje actualizado", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable ("id") int id){
		viajeService.delete(id);
		return new ResponseEntity("Viaje eliminado", HttpStatus.OK);
	}
}
