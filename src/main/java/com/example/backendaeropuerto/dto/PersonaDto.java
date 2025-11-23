package com.example.backendaeropuerto.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDto {
    private Long idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
