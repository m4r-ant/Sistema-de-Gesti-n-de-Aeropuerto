package com.example.backendaeropuerto.service;
import com.example.backendaeropuerto.model.Equipaje;
import com.example.backendaeropuerto.repository.EquipajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipajeService {

    private final EquipajeRepository repo;

    public EquipajeService(EquipajeRepository repo) {
        this.repo = repo;
    }

    public List<Equipaje> getAll() {
        return repo.findAll();
    }

    public Equipaje getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Equipaje no encontrado"));
    }

    public Equipaje save(Equipaje e) {
        return repo.save(e);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

