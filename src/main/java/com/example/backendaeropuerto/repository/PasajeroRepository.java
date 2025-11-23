package com.example.backendaeropuerto.repository;
import com.example.backendaeropuerto.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {
}
