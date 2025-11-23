package com.example.backendaeropuerto.controller;

import com.example.backendaeropuerto.dto.PuertaEmbarqueDto;
import com.example.backendaeropuerto.mapper.PuertaEmbarqueMapper;
import com.example.backendaeropuerto.model.PuertaEmbarque;
import com.example.backendaeropuerto.service.PuertaEmbarqueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/puertas")
public class PuertaEmbarqueController {

    private final PuertaEmbarqueService service;

    public PuertaEmbarqueController(PuertaEmbarqueService service) {
        this.service = service;
    }

    @GetMapping
    public List<PuertaEmbarqueDto> getAll() {
        return service.getAll()
                .stream()
                .map(PuertaEmbarqueMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public PuertaEmbarqueDto getById(@PathVariable Long id) {
        return PuertaEmbarqueMapper.toDto(service.getById(id));
    }

    @PostMapping
    public PuertaEmbarqueDto create(@RequestBody PuertaEmbarqueDto dto) {
        PuertaEmbarque p = PuertaEmbarqueMapper.toEntity(dto);
        PuertaEmbarque saved = service.save(p);
        return PuertaEmbarqueMapper.toDto(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
