package com.spacework.controller;

import com.spacework.model.Espacio;
import com.spacework.repository.EspacioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/espacios")
public class EspacioController {

    private final EspacioRepository espacioRepository;

    public EspacioController(EspacioRepository espacioRepository) {
        this.espacioRepository = espacioRepository;
    }

    @GetMapping
    public List<Espacio> listar(@RequestParam(required = false) String tipo) {
        if (tipo != null && !tipo.isBlank()) {
            return espacioRepository.findByTipo(tipo);
        }
        return espacioRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Espacio crear(@RequestBody Espacio espacio) {
        return espacioRepository.save(espacio);
    }
}
