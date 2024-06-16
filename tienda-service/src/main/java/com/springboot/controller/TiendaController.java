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

import com.springboot.dto.TiendaDTO;
import com.springboot.entity.Tienda;
import com.springboot.service.TiendaService;

@RestController
@RequestMapping("/apitienda")
public class TiendaController {

	@Autowired
	TiendaService tiendaService;

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
	public ResponseEntity<List<Tienda>> listar() {
		List<Tienda> listaTienda = tiendaService.listar();
		return new ResponseEntity<List<Tienda>>(listaTienda, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody TiendaDTO tiendaDTO) {
		Tienda tienda = new Tienda(tiendaDTO.getPsEx(),
				tiendaDTO.getDestinatario(),
				tiendaDTO.getNombreTienda(),
				tiendaDTO.getDistrito(),
				tiendaDTO.getDireccion(),
				tiendaDTO.getHoraInicio(),
				tiendaDTO.getHoraFin(),
				tiendaDTO.getContacto());
		tiendaService.save(tienda);
		return new ResponseEntity<>("Tienda agregada", HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody TiendaDTO tiendaDTO) {
		Tienda tienda = tiendaService.getOne(id).get();
		tienda.setPsEx(tiendaDTO.getPsEx());
		tienda.setDestinatario(tiendaDTO.getDestinatario());
		tienda.setNombreTienda(tiendaDTO.getNombreTienda());
		tienda.setDistrito(tiendaDTO.getDistrito());
		tienda.setDireccion(tiendaDTO.getDireccion());
		tienda.setHoraInicio(tiendaDTO.getHoraInicio());
		tienda.setHoraFin(tiendaDTO.getHoraFin());
		tienda.setContacto(tiendaDTO.getContacto());
		tiendaService.save(tienda);
		return new ResponseEntity<>("Tienda actualizada", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		tiendaService.delete(id);
		return new ResponseEntity<>("Tienda eliminada", HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tienda> getTiendaById(@PathVariable("id") int id) {
		Optional<Tienda> optionalTienda = tiendaService.getOne(id);

		if (optionalTienda.isPresent()) {
			return ResponseEntity.ok(optionalTienda.get());
		} else {
			return ResponseEntity.status(404).body(null);
		}
	}
}
