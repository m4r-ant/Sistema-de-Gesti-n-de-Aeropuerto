package com.example.backendaeropuerto.mapper;
import com.example.backendaeropuerto.dto.AeronaveDto;
import  com.example.backendaeropuerto.model.Aeronave;


public class AeronaveMapper {

    public static AeronaveDto toDto(Aeronave a) {
        AeronaveDto d = new AeronaveDto();
        d.setIdAeronave(a.getIdAeronave());
        d.setModelo(a.getModelo());
        d.setMatricula(a.getMatricula());
        d.setCapacidad(a.getCapacidad());
        return d;
    }

    public static Aeronave toEntity(AeronaveDto d) {
        Aeronave a = new Aeronave();
        a.setModelo(d.getModelo());
        a.setMatricula(d.getMatricula());
        a.setCapacidad(d.getCapacidad());
        return a;
    }
}
