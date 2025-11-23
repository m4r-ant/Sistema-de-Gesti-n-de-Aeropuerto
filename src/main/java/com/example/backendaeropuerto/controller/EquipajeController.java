package com.example.backendaeropuerto.controller;

import com.example.backendaeropuerto.dto.EquipajeDto;
import com.example.backendaeropuerto.mapper.EquipajeMapper;
import com.example.backendaeropuerto.model.Equipaje;
import com.example.backendaeropuerto.service.EquipajeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipajes")
public class EquipajeController {

    private final EquipajeService service;

    public EquipajeController(EquipajeService service) {
        this.service = service;
    }

    @GetMapping
    public List<EquipajeDto> getAll() {
        return service.getAll()
                .stream()
                .map(EquipajeMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public EquipajeDto getById(@PathVariable Long id) {
        return EquipajeMapper.toDto(service.getById(id));
    }

    @PostMapping
    public EquipajeDto create(@RequestBody EquipajeDto dto) {
        Equipaje e = EquipajeMapper.toEntity(dto);
        Equipaje saved = service.save(e);
        return EquipajeMapper.toDto(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
