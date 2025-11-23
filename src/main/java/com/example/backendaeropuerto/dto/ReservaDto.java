package com.example.backendaeropuerto.dto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ReservaDto {
    private Long idReserva;
    private Long idPasajero;
    private Long idVuelo;
    private String codigoReserva;
    private String estado;
    private BigDecimal precio;
}
