package com.idch.mlme.controllers;

import com.idch.mlme.dto.DnaDTO;
import com.idch.mlme.dto.StatisticDTO;
import com.idch.mlme.entities.Person;
import com.idch.mlme.service.PersonService;
import com.idch.mlme.utils.DnaUtils;
import com.idch.mlme.utils.StatsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/mutant")
    public ResponseEntity<String> mutant(@RequestBody DnaDTO dna) {
        if (dna.getDna() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        if (!DnaUtils.isMinlengthMatrix(dna.getDna().length) && DnaUtils.isValidateSquareMatrixAndValues(dna.getDna())) {
            String dnaString = Arrays.toString(dna.getDna()).replaceAll("[\\[\\] ]+", "");
            Person person = new Person();
            person.setDna(dnaString);
            if (DnaUtils.isMutant(dna.getDna())) {
                person.setMutant(true);
                if (personService.findByDna(dnaString).isEmpty())
                    personService.savePerson(person);
                return ResponseEntity.status(HttpStatus.OK).body("Mutant");
            } else {
                person.setMutant(false);
                if (personService.findByDna(dnaString).isEmpty())
                    personService.savePerson(person);
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Human");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Value error");
        }
    }

    @GetMapping("/stats")
    public @ResponseBody StatisticDTO getRatio(){
        return StatsUtils.calculateRatio(personService.countByMutant(false), personService.countByMutant(true));
    }
}
