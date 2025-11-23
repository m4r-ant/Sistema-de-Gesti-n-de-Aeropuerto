package com.example.backendaeropuerto.controller;

import com.example.backendaeropuerto.dto.VueloDto;
import com.example.backendaeropuerto.mapper.VueloMapper;
import com.example.backendaeropuerto.model.Vuelo;
import com.example.backendaeropuerto.service.VueloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    private final VueloService service;

    public VueloController(VueloService service) {
        this.service = service;
    }

    @GetMapping
    public List<VueloDto> getAll() {
        return service.getAll()
                .stream()
                .map(VueloMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public VueloDto getById(@PathVariable Long id) {
        return VueloMapper.toDto(service.getById(id));
    }

    @PostMapping
    public VueloDto create(@RequestBody VueloDto dto) {
        Vuelo v = VueloMapper.toEntity(dto);
        Vuelo saved = service.save(v);
        return VueloMapper.toDto(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
