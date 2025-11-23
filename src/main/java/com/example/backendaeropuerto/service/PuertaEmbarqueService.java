package com.example.backendaeropuerto.service;
import com.example.backendaeropuerto.model.PuertaEmbarque;
import com.example.backendaeropuerto.repository.PuertaEmbarqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuertaEmbarqueService {

    private final PuertaEmbarqueRepository repo;

    public PuertaEmbarqueService(PuertaEmbarqueRepository repo) {
        this.repo = repo;
    }

    public List<PuertaEmbarque> getAll() {
        return repo.findAll();
    }

    public PuertaEmbarque getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Puerta no encontrada"));
    }

    public PuertaEmbarque save(PuertaEmbarque p) {
        return repo.save(p);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
