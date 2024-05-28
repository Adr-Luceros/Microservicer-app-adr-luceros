package com.api.config_server.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @GetMapping()
    public String getMethodName() {
        return "Ejecutando el servidor";
    }

}
