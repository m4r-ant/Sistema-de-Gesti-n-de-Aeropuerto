package com.example.backendaeropuerto.mapper;
import com.example.backendaeropuerto.dto.ReservaDto;
import com.example.backendaeropuerto.model.*;

public class ReservaMapper {

    public static ReservaDto toDto(Reserva r) {
        ReservaDto d = new ReservaDto();
        d.setIdReserva(r.getIdReserva());
        d.setIdPasajero(r.getPasajero() != null ? r.getPasajero().getIdPasajero() : null);
        d.setIdVuelo(r.getVuelo() != null ? r.getVuelo().getIdVuelo() : null);
        d.setCodigoReserva(r.getCodigoReserva());
        d.setEstado(r.getEstado());
        d.setPrecio(r.getPrecio());
        return d;
    }

    public static Reserva toEntity(ReservaDto d) {
        Reserva r = new Reserva();

        Pasajero p = new Pasajero();
        p.setIdPasajero(d.getIdPasajero());
        r.setPasajero(p);

        Vuelo v = new Vuelo();
        v.setIdVuelo(d.getIdVuelo());
        r.setVuelo(v);

        r.setCodigoReserva(d.getCodigoReserva());
        r.setEstado(d.getEstado());
        r.setPrecio(d.getPrecio());

        return r;
    }
}
