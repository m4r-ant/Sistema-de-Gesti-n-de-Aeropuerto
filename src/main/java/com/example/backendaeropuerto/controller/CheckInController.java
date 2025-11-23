package com.example.backendaeropuerto.controller;

import com.example.backendaeropuerto.dto.CheckInDto;
import com.example.backendaeropuerto.mapper.CheckInMapper;
import com.example.backendaeropuerto.model.CheckIn;
import com.example.backendaeropuerto.service.CheckInService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkin")
public class CheckInController {

    private final CheckInService service;

    public CheckInController(CheckInService service) {
        this.service = service;
    }

    @GetMapping
    public List<CheckInDto> getAll() {
        return service.getAll()
                .stream()
                .map(CheckInMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public CheckInDto getById(@PathVariable Long id) {
        return CheckInMapper.toDto(service.getById(id));
    }

    @PostMapping
    public CheckInDto create(@RequestBody CheckInDto dto) {
        CheckIn c = CheckInMapper.toEntity(dto);
        CheckIn saved = service.save(c);
        return CheckInMapper.toDto(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
