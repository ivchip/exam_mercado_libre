package com.idch.mlme.controllers;

import com.idch.mlme.dto.DnaDTO;
import com.idch.mlme.dto.PersonDTO;
import com.idch.mlme.dto.StatisticDTO;
import com.idch.mlme.service.DnaService;
import com.idch.mlme.utils.DnaUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    private DnaService personService;

    /**
     * Constructor
     *
     * @param personService
     */
    public PersonController(DnaService personService) {
        this.personService = personService;
    }

    /**
     * Method for identify mutant and save register
     *
     * @return
     */
    @ApiOperation(value = "Identify mutant and save register", notes = "")
    @PostMapping("/mutant")
    public ResponseEntity<String> mutant(@RequestBody @Valid DnaDTO dna) {
        if (DnaUtils.isMinlengthMatrix(dna.getDna().length) && DnaUtils.isValidMatrix(dna.getDna())) {
            PersonDTO personDTO = personService.savePerson(dna);
            if (personDTO.getMutant()) {
                return ResponseEntity.status(HttpStatus.OK).body("Mutant");
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Human");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Value error");
        }
    }

    /**
     * Method for getting ratio
     *
     * @return
     */
    @ApiOperation(value = "Get a ratio", notes = "", response = StatisticDTO.class)
    @GetMapping("/stats")
    public ResponseEntity<StatisticDTO> getStats() {
        return ResponseEntity.status(HttpStatus.OK).body(personService.calculateRatio());
    }
}
