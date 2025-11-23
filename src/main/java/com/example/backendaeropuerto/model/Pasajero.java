package com.example.backendaeropuerto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pasajero")
@Getter
@Setter
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pasajero")
    private Long idPasajero;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "nacionalidad", length = 50)
    private String nacionalidad;

    @Column(name = "tipo_documento", length = 20)
    private String tipoDocumento;
}
