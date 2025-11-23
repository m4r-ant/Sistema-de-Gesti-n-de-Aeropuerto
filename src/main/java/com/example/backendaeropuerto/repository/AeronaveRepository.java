package com.example.backendaeropuerto.repository;
import com.example.backendaeropuerto.model.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeronaveRepository extends JpaRepository<Aeronave, Long> {
}
