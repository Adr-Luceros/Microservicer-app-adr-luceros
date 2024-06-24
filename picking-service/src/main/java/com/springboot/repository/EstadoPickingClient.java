package com.springboot.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.entity.EstadoPicking;

@FeignClient(name = "estadoPicking-service")
public interface EstadoPickingClient {

	  @GetMapping("/apiestadopicking/{id}")
	    EstadoPicking getEstadoPickingById(@PathVariable("id") Integer id);
}
