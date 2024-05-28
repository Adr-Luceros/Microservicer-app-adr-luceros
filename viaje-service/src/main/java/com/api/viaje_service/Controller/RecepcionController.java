package com.api.viaje_service.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.viaje_service.Dto.RecepcionData;
import com.api.viaje_service.Service.RecepcionService;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/recopilar")
public class RecepcionController {

    @Autowired
    RecepcionService recepcionService;

    @PostMapping("/excel")
    public ResponseEntity<List<RecepcionData>> processExcel(@RequestParam(name = "file") MultipartFile file) {
        List<RecepcionData> result = recepcionService.convertExcelToData(file);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
