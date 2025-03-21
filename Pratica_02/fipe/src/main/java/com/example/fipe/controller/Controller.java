package com.example.fipe.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.example.fipe.service.FipeService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class Controller {

    @Autowired
    private FipeService fipeService;

    @GetMapping("/marcas")
    public ResponseEntity<Object> consultarMarcas() {
        return ResponseEntity.ok(fipeService.consultarMarcas());
    }

    @GetMapping("/modelos/{marca}")
    public ResponseEntity<Object> consultarModelos(@PathVariable int marca) {
        return ResponseEntity.ok(fipeService.consultarModelos(marca));
    }

    @GetMapping("/anos/{marca}/{modelo}")
    public ResponseEntity<Object> consultarAnos(@PathVariable int marca, @PathVariable int modelo) {
        return ResponseEntity.ok(fipeService.consultarAnos(marca, modelo));
    }

    @GetMapping("/valor/{marca}/{modelo}/{ano}")
    public ResponseEntity<Object> consultarValor(@PathVariable int marca, @PathVariable int modelo, @PathVariable String ano) {
        return ResponseEntity.ok(fipeService.consultarValor(marca, modelo, ano));
    }
}
