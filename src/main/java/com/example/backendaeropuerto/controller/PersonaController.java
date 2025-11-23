package com.example.backendaeropuerto.controller;

import com.example.backendaeropuerto.dto.PersonaDto;
import com.example.backendaeropuerto.mapper.PersonaMapper;
import com.example.backendaeropuerto.model.Persona;
import com.example.backendaeropuerto.service.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService service;

    public PersonaController(PersonaService service) {
        this.service = service;
    }

    @GetMapping
    public List<PersonaDto> getAll() {
        return service.getAll()
                .stream()
                .map(PersonaMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public PersonaDto getById(@PathVariable Long id) {
        return PersonaMapper.toDto(service.getById(id));
    }

    @PostMapping
    public PersonaDto create(@RequestBody PersonaDto dto) {
        Persona p = PersonaMapper.toEntity(dto);
        Persona saved = service.save(p);
        return PersonaMapper.toDto(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
