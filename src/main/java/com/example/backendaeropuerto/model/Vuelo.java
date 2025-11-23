package com.example.backendaeropuerto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "vuelo")
@Getter
@Setter
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vuelo")
    private Long idVuelo;

    @Column(name = "numero_vuelo", length = 10, unique = true, nullable = false)
    private String numeroVuelo;

    @Column(name = "fecha_salida", nullable = false)
    private LocalDate fechaSalida;

    @Column(name = "hora_salida", nullable = false)
    private LocalTime horaSalida;

    @Column(name = "estado", length = 20)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_aeronave")
    private Aeronave aeronave;

    @ManyToOne
    @JoinColumn(name = "id_puerta")
    private PuertaEmbarque puertaEmbarque;
}
