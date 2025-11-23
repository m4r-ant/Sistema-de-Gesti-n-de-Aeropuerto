package com.example.backendaeropuerto.service;
import com.example.backendaeropuerto.model.Aeronave;
import com.example.backendaeropuerto.repository.AeronaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeronaveService {

    private final AeronaveRepository repo;

    public AeronaveService(AeronaveRepository repo) {
        this.repo = repo;
    }

    public List<Aeronave> getAll() {
        return repo.findAll();
    }

    public Aeronave getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Aeronave no encontrada"));
    }

    public Aeronave save(Aeronave a) {
        return repo.save(a);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
