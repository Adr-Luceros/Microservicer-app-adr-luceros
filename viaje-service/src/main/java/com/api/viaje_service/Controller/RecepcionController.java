package com.api.viaje_service.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.viaje_service.Service.RecepcionService;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/recopilar")
public class RecepcionController {

    @PostMapping("/excel")
    public ResponseEntity<List<Map<String, Object>>> processExcel(@RequestParam(name = "file") MultipartFile file) {
        List<Map<String, Object>> result = RecepcionService.convertExcelRow(file);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
