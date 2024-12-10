package net.javaguides.plan.mapper;

import net.javaguides.plan.dto.OsobnoDto;
import net.javaguides.plan.entity.Osobno;

public class OsobnoMapper {
    public static OsobnoDto mapToOsobnoDto(Osobno osobno){
        return new OsobnoDto(
                osobno.getId(),
                osobno.getTemat(),
                osobno.getOpis(),
                osobno.getDataTerminu()
        );
    }
    public static Osobno maptoOsobno(OsobnoDto osobnoDto){
        return new Osobno(
                osobnoDto.getId(),
                osobnoDto.getTemat(),
                osobnoDto.getOpis(),
                osobnoDto.getDataTerminu()
        );
    }
}
