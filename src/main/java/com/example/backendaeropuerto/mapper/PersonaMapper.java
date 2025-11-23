package com.example.backendaeropuerto.mapper;
import com.example.backendaeropuerto.dto.PersonaDto;
import com.example.backendaeropuerto.model.Persona;

public class PersonaMapper {
    public static PersonaDto toDto(Persona p) {
        PersonaDto d = new PersonaDto();
        d.setIdPersona(p.getIdPersona());
        d.setNombre(p.getNombre());
        d.setApellido(p.getApellido());
        d.setEmail(p.getEmail());
        d.setTelefono(p.getTelefono());
        return d;
    }
    public static Persona toEntity(PersonaDto d) {
        Persona p = new Persona();
        p.setNombre(d.getNombre());
        p.setApellido(d.getApellido());
        p.setEmail(d.getEmail());
        p.setTelefono(d.getTelefono());
        return p;
    }
}
