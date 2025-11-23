package com.example.backendaeropuerto.mapper;
import  com.example.backendaeropuerto.dto.PasajeroDto;
import com.example.backendaeropuerto.model.Pasajero;
import com.example.backendaeropuerto.model.Persona;

public class PasajeroMapper {

    public static PasajeroDto toDto(Pasajero p) {
        PasajeroDto d = new PasajeroDto();
        d.setIdPasajero(p.getIdPasajero());
        d.setIdPersona(p.getPersona() != null ? p.getPersona().getIdPersona() : null);
        d.setNacionalidad(p.getNacionalidad());
        d.setTipoDocumento(p.getTipoDocumento());
        return d;
    }

    public static Pasajero toEntity(PasajeroDto d) {
        Pasajero p = new Pasajero();
        Persona persona = new Persona();
        persona.setIdPersona(d.getIdPersona());
        p.setPersona(persona);
        p.setNacionalidad(d.getNacionalidad());
        p.setTipoDocumento(d.getTipoDocumento());
        return p;
    }
}
