package com.example.backendaeropuerto.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "puerta_embarque")
@Getter
@Setter
public class PuertaEmbarque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_puerta")
    private Long idPuerta;

    @Column(name = "numero_puerta", length = 10)
    private String numeroPuerta;

    @Column(name = "terminal", length = 20)
    private String terminal;
}
