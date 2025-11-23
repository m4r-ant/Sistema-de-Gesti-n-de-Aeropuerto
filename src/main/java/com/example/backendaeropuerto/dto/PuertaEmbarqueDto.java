package com.example.backendaeropuerto.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PuertaEmbarqueDto {
    private Long idPuerta;
    private String numeroPuerta;
    private String terminal;
}
