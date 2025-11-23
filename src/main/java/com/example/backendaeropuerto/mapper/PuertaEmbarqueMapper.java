package com.example.backendaeropuerto.mapper;
import com.example.backendaeropuerto.dto.PuertaEmbarqueDto;
import com.example.backendaeropuerto.model.PuertaEmbarque;

public class PuertaEmbarqueMapper {

    public static PuertaEmbarqueDto toDto(PuertaEmbarque p) {
        PuertaEmbarqueDto d = new PuertaEmbarqueDto();
        d.setIdPuerta(p.getIdPuerta());
        d.setNumeroPuerta(p.getNumeroPuerta());
        d.setTerminal(p.getTerminal());
        return d;
    }

    public static PuertaEmbarque toEntity(PuertaEmbarqueDto d) {
        PuertaEmbarque p = new PuertaEmbarque();
        p.setNumeroPuerta(d.getNumeroPuerta());
        p.setTerminal(d.getTerminal());
        return p;
    }
}
