package com.example.backendaeropuerto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "aeronave")
@Getter
@Setter
public class Aeronave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aeronave")
    private Long idAeronave;

    @Column(name = "modelo", length = 50)
    private String modelo;

    @Column(name = "matricula", length = 10)
    private String matricula;

    @Column(name = "capacidad")
    private Integer capacidad;
}
