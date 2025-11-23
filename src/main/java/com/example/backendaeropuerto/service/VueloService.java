package com.example.backendaeropuerto.service;
import com.example.backendaeropuerto.model.Vuelo;
import com.example.backendaeropuerto.repository.VueloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloService {

    private final VueloRepository repo;

    public VueloService(VueloRepository repo) {
        this.repo = repo;
    }

    public List<Vuelo> getAll() {
        return repo.findAll();
    }

    public Vuelo getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
    }

    public Vuelo save(Vuelo v) {
        return repo.save(v);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
