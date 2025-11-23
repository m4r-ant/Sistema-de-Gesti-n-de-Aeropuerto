package com.example.backendaeropuerto.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "reserva")
@Getter
@Setter
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "id_pasajero")
    private Pasajero pasajero;

    @ManyToOne
    @JoinColumn(name = "id_vuelo")
    private Vuelo vuelo;

    @Column(name = "codigo_reserva", length = 10, unique = true, nullable = false)
    private String codigoReserva;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(name = "precio", precision = 10, scale = 2)
    private BigDecimal precio;
}
