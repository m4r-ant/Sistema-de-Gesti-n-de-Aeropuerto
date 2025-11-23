package com.example.backendaeropuerto.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AeronaveDto {
    private Long idAeronave;
    private String modelo;
    private String matricula;
    private Integer capacidad;
}
