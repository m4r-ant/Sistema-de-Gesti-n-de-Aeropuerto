package com.example.backendaeropuerto.service;
import com.example.backendaeropuerto.model.Persona;
import com.example.backendaeropuerto.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    private final PersonaRepository repo;

    public PersonaService(PersonaRepository repo) {
        this.repo = repo;
    }

    public List<Persona> getAll() {
        return repo.findAll();
    }

    public Persona getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    public Persona save(Persona p) {
        return repo.save(p);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
