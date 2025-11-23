package com.example.backendaeropuerto.dto;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class CheckInDto {
    private Long idCheckin;
    private Long idReserva;
    private Long idAsiento;
    private Long idPuerta;
    private LocalDate fechaCheckin;
    private LocalTime horaCheckin;
}
