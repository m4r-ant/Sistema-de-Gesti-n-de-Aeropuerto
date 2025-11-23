package com.example.backendaeropuerto.mapper;
import com.example.backendaeropuerto.dto.CheckInDto;
import com.example.backendaeropuerto.model.*;

public class CheckInMapper {

    public static CheckInDto toDto(CheckIn c) {
        CheckInDto d = new CheckInDto();
        d.setIdCheckin(c.getIdCheckin());
        d.setIdReserva(c.getReserva() != null ? c.getReserva().getIdReserva() : null);
        d.setIdAsiento(c.getIdAsiento());
        d.setIdPuerta(c.getPuerta() != null ? c.getPuerta().getIdPuerta() : null);
        d.setFechaCheckin(c.getFechaCheckin());
        d.setHoraCheckin(c.getHoraCheckin());
        return d;
    }

    public static CheckIn toEntity(CheckInDto d) {
        CheckIn c = new CheckIn();

        Reserva r = new Reserva();
        r.setIdReserva(d.getIdReserva());
        c.setReserva(r);

        PuertaEmbarque p = new PuertaEmbarque();
        p.setIdPuerta(d.getIdPuerta());
        c.setPuerta(p);

        c.setIdAsiento(d.getIdAsiento());
        c.setFechaCheckin(d.getFechaCheckin());
        c.setHoraCheckin(d.getHoraCheckin());

        return c;
    }
}
