package com.example.backendaeropuerto.mapper;
import com.example.backendaeropuerto.dto.VueloDto;
import com.example.backendaeropuerto.model.*;

public class VueloMapper {

    public static VueloDto toDto(Vuelo v) {
        VueloDto d = new VueloDto();
        d.setIdVuelo(v.getIdVuelo());
        d.setNumeroVuelo(v.getNumeroVuelo());
        d.setFechaSalida(v.getFechaSalida());
        d.setHoraSalida(v.getHoraSalida());
        d.setEstado(v.getEstado());
        d.setIdAeronave(v.getAeronave() != null ? v.getAeronave().getIdAeronave() : null);
        d.setIdPuerta(v.getPuertaEmbarque() != null ? v.getPuertaEmbarque().getIdPuerta() : null);
        return d;
    }

    public static Vuelo toEntity(VueloDto d) {
        Vuelo v = new Vuelo();
        v.setNumeroVuelo(d.getNumeroVuelo());
        v.setFechaSalida(d.getFechaSalida());
        v.setHoraSalida(d.getHoraSalida());
        v.setEstado(d.getEstado());

        Aeronave a = new Aeronave();
        a.setIdAeronave(d.getIdAeronave());
        v.setAeronave(a);

        PuertaEmbarque p = new PuertaEmbarque();
        p.setIdPuerta(d.getIdPuerta());
        v.setPuertaEmbarque(p);

        return v;
    }
}
