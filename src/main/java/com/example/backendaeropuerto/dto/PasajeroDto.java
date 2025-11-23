package com.example.backendaeropuerto.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasajeroDto {
    private Long idPasajero;
    private Long idPersona;
    private String nacionalidad;
    private String tipoDocumento;
}
