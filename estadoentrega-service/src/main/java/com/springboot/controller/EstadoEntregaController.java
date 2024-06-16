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

import com.springboot.dto.EstadoEntregaDTO;
import com.springboot.entity.EstadoEntrega;
import com.springboot.service.EstadoEntregaService;

@RestController
@RequestMapping("/apiestadoentrega")
public class EstadoEntregaController {

	
	@Autowired
	EstadoEntregaService estadoEntregaService;
	
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
	public ResponseEntity<List<EstadoEntrega>> listar(){
		List<EstadoEntrega> listaEstadoEntrega = estadoEntregaService.listar();
		return new ResponseEntity<List<EstadoEntrega>> (listaEstadoEntrega, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create (@RequestBody EstadoEntregaDTO estadoEntregaDTO){
		EstadoEntrega estadoEntrega = new EstadoEntrega(estadoEntregaDTO.getNombre());
		
		estadoEntregaService.save(estadoEntrega);
		return new ResponseEntity("EstadoEntrega agregado", HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable ("id") int id, @RequestBody EstadoEntregaDTO estadoEntregaDTO){
		EstadoEntrega estadoEntrega = estadoEntregaService.getOne(id).get();
		estadoEntrega.setNombre(estadoEntregaDTO.getNombre());
		
		
		estadoEntregaService.save(estadoEntrega);
		return new ResponseEntity("EstadoEntrega actualizado", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable ("id") int id){
		estadoEntregaService.delete(id);
		return new ResponseEntity("EstadoEntrega eliminado", HttpStatus.OK);
	}
}
