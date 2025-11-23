package com.example.backendaeropuerto.repository;
import com.example.backendaeropuerto.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
}
