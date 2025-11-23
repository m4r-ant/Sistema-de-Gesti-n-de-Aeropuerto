package com.example.backendaeropuerto.repository;
import com.example.backendaeropuerto.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
