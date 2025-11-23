package com.example.backendaeropuerto.service;
import com.example.backendaeropuerto.model.CheckIn;
import com.example.backendaeropuerto.repository.CheckInRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInService {

    private final CheckInRepository repo;

    public CheckInService(CheckInRepository repo) {
        this.repo = repo;
    }

    public List<CheckIn> getAll() {
        return repo.findAll();
    }

    public CheckIn getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Check-in no encontrado"));
    }

    public CheckIn save(CheckIn c) {
        return repo.save(c);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
