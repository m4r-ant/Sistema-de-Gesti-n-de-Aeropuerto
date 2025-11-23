package com.example.backendaeropuerto.repository;
import com.example.backendaeropuerto.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
