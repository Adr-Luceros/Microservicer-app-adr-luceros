package com.service.excel_service.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.service.excel_service.Dto.RecepcionData;
import com.service.excel_service.Dto.ViajeDto;
import com.service.excel_service.Entity.Mensaje;
import com.service.excel_service.Entity.Personal;
import com.service.excel_service.Entity.Viaje;
import com.service.excel_service.Service.AgruparService;
import com.service.excel_service.Service.AlmacenarDatosService;
import com.service.excel_service.Service.ExcelService;
import com.service.excel_service.Service.RecepcionService;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/recopilar")
public class RecepcionController {

    @Autowired
    RecepcionService recepcionService;

    @Autowired
    AgruparService agruparService;

    @Autowired
    AlmacenarDatosService almacenarDataService;
    
    @Autowired
    ExcelService excelService;

    @PostMapping("/excel")
    public ResponseEntity<?> processExcel(@RequestParam(name = "file") MultipartFile file) {
        Mensaje result = new Mensaje("Datos recopilados y guardados correctamente");

        List<RecepcionData> dataList = null;
        try {
            dataList = recepcionService.convertExcelToData(file);
        } catch (Exception e) {
            result.setMensaje("Error en la lectura del excel");
            List<String> observaciones = new ArrayList<String>();
            observaciones.add("Archivo inválido");
            observaciones.add("Archivo de excel muy grande");
            observaciones.add("Las columnas del archivo no son válidas");
            observaciones.add("Error en los datos de entrada");
            result.setObservaciones(observaciones);
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        List<ViajeDto> viajes = null;
        try {
            viajes = agruparService.agrupar(dataList);
        } catch (Exception e) {
            result.setMensaje("Error en la agrupación de viajes");
            List<String> observaciones = new ArrayList<String>();
            observaciones.add("datos invalidos inválido");
            observaciones.add("Existe incoherencia entre los datos");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        try {
            almacenarDataService.almacenar(viajes);
        } catch (Exception e) {
            result.setMensaje("Error del servidor");
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Viaje>> getAllViajes() {
        List<Viaje> viajes = almacenarDataService.getAllViajesHoy();

        if (viajes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(viajes, HttpStatus.OK);
    }
    
    @GetMapping("/apipersonal/listar")
    public List<Personal> getAllPersonal(){
    	return excelService.getAllPersonal();
    }

}
