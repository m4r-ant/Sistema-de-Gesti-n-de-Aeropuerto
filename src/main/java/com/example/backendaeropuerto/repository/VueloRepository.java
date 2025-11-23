package com.example.backendaeropuerto.repository;
import com.example.backendaeropuerto.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
}

