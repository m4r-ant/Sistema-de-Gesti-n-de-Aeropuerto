package com.example.backendaeropuerto.service;
import com.example.backendaeropuerto.model.Pasajero;
import com.example.backendaeropuerto.repository.PasajeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroService {

    private final PasajeroRepository repo;

    public PasajeroService(PasajeroRepository repo) {
        this.repo = repo;
    }

    public List<Pasajero> getAll() {
        return repo.findAll();
    }

    public Pasajero getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Pasajero no encontrado"));
    }

    public Pasajero save(Pasajero p) {
        return repo.save(p);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
