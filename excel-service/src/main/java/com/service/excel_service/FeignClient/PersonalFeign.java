package com.service.excel_service.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.service.excel_service.Entity.Personal;


@FeignClient(name = "personal-service", url = "http://localhost:8853")
public interface PersonalFeign {

	@GetMapping("/apipersonal/listar")
	List<Personal> getAllPersonal();
}
