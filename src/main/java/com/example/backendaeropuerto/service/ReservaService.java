package com.example.backendaeropuerto.service;
import com.example.backendaeropuerto.model.Reserva;
import com.example.backendaeropuerto.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository repo;

    public ReservaService(ReservaRepository repo) {
        this.repo = repo;
    }

    public List<Reserva> getAll() {
        return repo.findAll();
    }

    public Reserva getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    public Reserva save(Reserva r) {
        return repo.save(r);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
