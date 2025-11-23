package com.example.backendaeropuerto.mapper;
import com.example.backendaeropuerto.dto.EquipajeDto;
import com.example.backendaeropuerto.model.Equipaje;
import com.example.backendaeropuerto.model.Pasajero;

public class EquipajeMapper {

    public static EquipajeDto toDto(Equipaje e) {
        EquipajeDto d = new EquipajeDto();
        d.setIdEquipaje(e.getIdEquipaje());
        d.setIdPasajero(e.getPasajero() != null ? e.getPasajero().getIdPasajero() : null);
        d.setPeso(e.getPeso());
        d.setTipo(e.getTipo());
        d.setLocalizacion(e.getLocalizacion());
        return d;
    }

    public static Equipaje toEntity(EquipajeDto d) {
        Equipaje e = new Equipaje();
        Pasajero p = new Pasajero();
        p.setIdPasajero(d.getIdPasajero());
        e.setPasajero(p);
        e.setPeso(d.getPeso());
        e.setTipo(d.getTipo());
        e.setLocalizacion(d.getLocalizacion());
        return e;
    }
}
