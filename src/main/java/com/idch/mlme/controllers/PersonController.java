package com.idch.mlme.controllers;

import com.idch.mlme.dto.DnaDTO;
import com.idch.mlme.dto.StatisticDTO;
import com.idch.mlme.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/mutant")
    public ResponseEntity<String> mutant(@RequestBody DnaDTO dna) {
        Short result = personService.savePerson(dna);
        if (result == -1)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Value error");
        if (result == -2)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Human");
        else
            return ResponseEntity.status(HttpStatus.OK).body("Mutant");
    }

    @GetMapping("/stats")
    public ResponseEntity<StatisticDTO> getRatio() {
        return ResponseEntity.status(HttpStatus.OK).body(personService.calculateRatio());
    }
}
