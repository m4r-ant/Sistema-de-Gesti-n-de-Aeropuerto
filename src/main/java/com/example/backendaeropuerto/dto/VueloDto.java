package com.example.backendaeropuerto.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class VueloDto {
    private Long idVuelo;
    private String numeroVuelo;
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private String estado;
    private Long idAeronave;
    private Long idPuerta;
}
