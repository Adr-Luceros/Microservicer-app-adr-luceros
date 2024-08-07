package com.springboot.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.entity.Flete;

@FeignClient(name = "flete-service", url = "http://localhost:8080")
public interface FleteFeignClient {

    @GetMapping("/apiflete/byNombreRuta/{nombreRuta}")
    List<Flete> getFletesByRutaNombre(@PathVariable("nombreRuta") String nombreRuta);
}
