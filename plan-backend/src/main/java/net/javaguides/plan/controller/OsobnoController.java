package net.javaguides.plan.controller;

import lombok.AllArgsConstructor;
import net.javaguides.plan.dto.OsobnoDto;
import net.javaguides.plan.service.OsobnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/planner")
public class OsobnoController {

    private OsobnoService osobnoService;

    //Rest API
    @PostMapping
    public ResponseEntity<OsobnoDto> createOsobno(@RequestBody OsobnoDto osobnoDto){
        OsobnoDto savedOsobno=osobnoService.createOsobno(osobnoDto);
        return new ResponseEntity<>(savedOsobno, HttpStatus.CREATED);
    }

    //Get Restp Api
    @GetMapping("{id}")
    public ResponseEntity<OsobnoDto> getOsobnoById(@PathVariable("id" )Long osobnoId){
        OsobnoDto osobnoDto=osobnoService.getOsosbnoByID(osobnoId);
        return ResponseEntity.ok(osobnoDto);
    }

    //Get all rest api
    @GetMapping()
    public ResponseEntity<List<OsobnoDto>> getAllOsobno(){
        List<OsobnoDto> osobno= osobnoService.getAlloOsobno();
        return ResponseEntity.ok(osobno);
    }

    //tutaj sie do updejtuje wszystko rest api
    @PutMapping("{id}")
    public ResponseEntity<OsobnoDto> updateWszystko(@PathVariable("id" ) Long osobnoId,@RequestBody OsobnoDto updateWszystko){
        OsobnoDto osobnoDto= osobnoService.updateWszystko(osobnoId,updateWszystko);
        return ResponseEntity.ok(osobnoDto);
    }
    //usuwanie rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteElement(@PathVariable("id") Long osobnoId){
        osobnoService.deleteElement(osobnoId);
        return ResponseEntity.ok("Usunieto zadanie");
    }

    @DeleteMapping("/tasks")
    public ResponseEntity<Void> deleteAllTasks() {
        osobnoService.deleteAllTasks();
        return ResponseEntity.noContent().build();
    }


}
