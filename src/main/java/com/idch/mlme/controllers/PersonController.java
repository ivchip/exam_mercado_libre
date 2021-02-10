package com.idch.mlme.controllers;

import com.idch.mlme.dto.DnaDTO;
import com.idch.mlme.dto.StatisticDTO;
import com.idch.mlme.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for Person
 */
@Api(description = "Supports GET and POST operations", tags = {"person"})
@RestController
@RequestMapping("/api/v1")
public class PersonController {

    /**
     * Inject dependencies
     */
    private PersonService personService;

    /**
     * Constructor
     *
     * @param personService
     */
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Method for identify mutant and save register
     *
     * @return
     */
    @ApiOperation(value = "Identify mutant and save register", notes = "")
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

    /**
     * Method for getting ratio
     *
     * @return
     */
    @ApiOperation(value = "Get a ratio", notes = "", response = StatisticDTO.class)
    @GetMapping("/stats")
    public ResponseEntity<StatisticDTO> getRatio() {
        return ResponseEntity.status(HttpStatus.OK).body(personService.calculateRatio());
    }
}
