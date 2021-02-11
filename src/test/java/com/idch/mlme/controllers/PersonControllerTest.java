package com.idch.mlme.controllers;

import com.idch.mlme.dto.DnaDTO;
import com.idch.mlme.dto.StatisticDTO;
import com.idch.mlme.entities.Person;
import com.idch.mlme.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class PersonControllerTest {

    @MockBean
    private PersonRepository personRepository;

    @Autowired
    private PersonController personController;

    @Test
    public void mutantSuccessTest() {
        String[] dna = new String[4];
        dna[0] = "ACGT";
        dna[1] = "AAAG";
        dna[2] = "AGAA";
        dna[3] = "AACA";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);
        Person person = new Person();
        person.setDna("ACGT,AAAG,AGAA,AACA");
        person.setMutant(true);

        doReturn(person).when(personRepository).save(any());

        ResponseEntity<String> httpResponse = personController.mutant(dnaDTO);
        Assertions.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void humanSuccessTest() {
        String[] dna = new String[4];
        dna[0] = "ACGT";
        dna[1] = "CAAG";
        dna[2] = "AGTA";
        dna[3] = "AACA";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);
        Person person = new Person();
        person.setDna("ACGT,CAAG,AGTA,AACA");
        person.setMutant(true);

        doReturn(person).when(personRepository).save(any());

        ResponseEntity<String> httpResponse = personController.mutant(dnaDTO);
        Assertions.assertEquals(httpResponse.getStatusCode(), HttpStatus.FORBIDDEN);
    }

    @Test
    public void statsSuccessTest() {
        List<Object[]> result = new ArrayList<>();
        doReturn(result).when(personRepository).groupByAndCountByMutant();
        ResponseEntity<StatisticDTO> httpResponse = personController.getStats();
        Assertions.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
    }
}
