package com.example.backendaeropuerto.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "check_in")
@Getter
@Setter
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_checkin")
    private Long idCheckin;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    @Column(name = "id_asiento")
    private Long idAsiento;

    @ManyToOne
    @JoinColumn(name = "id_puerta")
    private PuertaEmbarque puerta;

    @Column(name = "fecha_checkin")
    private LocalDate fechaCheckin;

    @Column(name = "hora_checkin")
    private LocalTime horaCheckin;
}
