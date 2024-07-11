package com.springboot.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.entity.RolCargo;

@FeignClient(name = "rolcargo-service", url = "http://localhost:8080")
public interface RolCargoFeign {

	 @GetMapping("/apirolcargo/{id}")
	    RolCargo getRolCargoById(@PathVariable("id") Integer id);
}
