package net.javaguides.plan.service.imp;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import net.javaguides.plan.dto.OsobnoDto;
import net.javaguides.plan.entity.Osobno;
import net.javaguides.plan.exception.ResourceNotFoundException;
import net.javaguides.plan.mapper.OsobnoMapper;
import net.javaguides.plan.repository.OsobnoRepository;
import net.javaguides.plan.service.OsobnoService;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OsobnoServiceImp implements OsobnoService {

    private OsobnoRepository osobnoRepository;


    @Override
    @Transactional
    public void deleteAllTasks() {
        osobnoRepository.truncateTable();
    }


    @Override
    public OsobnoDto createOsobno(OsobnoDto osobnoDto) {

        Osobno osobno= OsobnoMapper.maptoOsobno(osobnoDto);
        Osobno savedOsobno=osobnoRepository.save(osobno);

        return OsobnoMapper.mapToOsobnoDto(savedOsobno);
    }

    @Override
    public OsobnoDto getOsosbnoByID(Long osobnoid) {
        Osobno osobno=osobnoRepository.findById(osobnoid).orElseThrow(()->new ResourceNotFoundException("Nie znaleziono zadania o podanym id: "+osobnoid));

        return OsobnoMapper.mapToOsobnoDto(osobno);
    }

    @Override
    public List<OsobnoDto> getAlloOsobno() {
        List<Osobno> osobnoList = osobnoRepository.findAll();
        return osobnoList.stream().map((osobno) -> OsobnoMapper.mapToOsobnoDto(osobno)).collect(Collectors.toList());
    }

    @Override
    public OsobnoDto updateWszystko(Long osobnoId, OsobnoDto updatedWszystko) {
        Osobno osobno=osobnoRepository.findById(osobnoId).orElseThrow(()->new ResourceNotFoundException("Taski o podanych id nie istnieją"+osobnoId));

        osobno.setTemat(updatedWszystko.getTemat());
        osobno.setOpis(updatedWszystko.getOpis());
        osobno.setDataTerminu(updatedWszystko.getDataTerminu());
        Osobno updatedOsobnoObj= osobnoRepository.save(osobno);
        return OsobnoMapper.mapToOsobnoDto(updatedOsobnoObj);

    }

    @Override
    public void deleteElement(Long osobnoId) {

        Osobno osobno=osobnoRepository.findById(osobnoId).orElseThrow(()->new ResourceNotFoundException("Taski o podanych id nie istnieją"+osobnoId));

        osobnoRepository.deleteById(osobnoId);
    }





}
