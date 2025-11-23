package com.example.backendaeropuerto.controller;

import com.example.backendaeropuerto.dto.ReservaDto;
import com.example.backendaeropuerto.mapper.ReservaMapper;
import com.example.backendaeropuerto.model.Reserva;
import com.example.backendaeropuerto.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ReservaDto> getAll() {
        return service.getAll()
                .stream()
                .map(ReservaMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ReservaDto getById(@PathVariable Long id) {
        return ReservaMapper.toDto(service.getById(id));
    }

    @PostMapping
    public ReservaDto create(@RequestBody ReservaDto dto) {
        Reserva r = ReservaMapper.toEntity(dto);
        Reserva saved = service.save(r);
        return ReservaMapper.toDto(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
