package com.example.backendaeropuerto.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "equipaje")
@Getter
@Setter
public class Equipaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipaje")
    private Long idEquipaje;

    @ManyToOne
    @JoinColumn(name = "id_pasajero")
    private Pasajero pasajero;

    @Column(name = "peso", precision = 6, scale = 2)
    private BigDecimal peso;

    @Column(name = "tipo", length = 20)
    private String tipo;

    @Column(name = "localizacion", length = 50)
    private String localizacion;
}
