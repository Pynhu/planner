package net.javaguides.plan.service;

import net.javaguides.plan.dto.OsobnoDto;
import net.javaguides.plan.entity.Osobno;
import net.javaguides.plan.mapper.OsobnoMapper;

import java.util.List;

public interface OsobnoService {
    OsobnoDto createOsobno(OsobnoDto osobnoDto);


    OsobnoDto getOsosbnoByID(Long osobnoid);


    List<OsobnoDto> getAlloOsobno();

    OsobnoDto updateWszystko(Long osobnoId, OsobnoDto updatedWszystko);

    void deleteElement(Long osobnoId);
    

    void deleteAllTasks();
}
