package com.example.backendaeropuerto.controller;

import com.example.backendaeropuerto.dto.AeronaveDto;
import com.example.backendaeropuerto.mapper.AeronaveMapper;
import com.example.backendaeropuerto.model.Aeronave;
import com.example.backendaeropuerto.service.AeronaveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aeronaves")
public class AeronaveController {

    private final AeronaveService service;

    public AeronaveController(AeronaveService service) {
        this.service = service;
    }

    @GetMapping
    public List<AeronaveDto> getAll() {
        return service.getAll()
                .stream()
                .map(AeronaveMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public AeronaveDto getById(@PathVariable Long id) {
        return AeronaveMapper.toDto(service.getById(id));
    }

    @PostMapping
    public AeronaveDto create(@RequestBody AeronaveDto dto) {
        Aeronave a = AeronaveMapper.toEntity(dto);
        Aeronave saved = service.save(a);
        return AeronaveMapper.toDto(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
