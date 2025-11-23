package com.example.backendaeropuerto.controller;

import com.example.backendaeropuerto.dto.PasajeroDto;
import com.example.backendaeropuerto.mapper.PasajeroMapper;
import com.example.backendaeropuerto.model.Pasajero;
import com.example.backendaeropuerto.service.PasajeroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pasajeros")
public class PasajeroController {

    private final PasajeroService service;

    public PasajeroController(PasajeroService service) {
        this.service = service;
    }

    @GetMapping
    public List<PasajeroDto> getAll() {
        return service.getAll()
                .stream()
                .map(PasajeroMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public PasajeroDto getById(@PathVariable Long id) {
        return PasajeroMapper.toDto(service.getById(id));
    }

    @PostMapping
    public PasajeroDto create(@RequestBody PasajeroDto dto) {
        Pasajero p = PasajeroMapper.toEntity(dto);
        Pasajero saved = service.save(p);
        return PasajeroMapper.toDto(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
