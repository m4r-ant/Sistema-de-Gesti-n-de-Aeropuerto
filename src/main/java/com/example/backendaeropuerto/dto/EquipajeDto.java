package com.example.backendaeropuerto.dto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EquipajeDto {
    private Long idEquipaje;
    private Long idPasajero;
    private BigDecimal peso;
    private String tipo;
    private String localizacion;
}
