package com.idch.mlme.services;

import com.idch.mlme.dto.DnaDTO;
import com.idch.mlme.dto.PersonDTO;
import com.idch.mlme.entities.Person;
import com.idch.mlme.repository.PersonRepository;
import com.idch.mlme.service.DnaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class DnaServiceTest {

    @MockBean
    private PersonRepository personRepository;

    @Autowired
    private DnaService dnaService;

    @Test
    void saveMutantTest() {
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

        PersonDTO savePerson = dnaService.savePerson(dnaDTO);

        Assertions.assertEquals(savePerson.getDna(), "ACGT,AAAG,AGAA,AACA");
        Assertions.assertEquals(savePerson.getMutant(), true);
    }

    @Test
    void saveHumanTest() {
        String[] dna = new String[4];
        dna[0] = "ACGT";
        dna[1] = "CTAG";
        dna[2] = "TGCA";
        dna[3] = "AACC";
        DnaDTO dnaDTO = new DnaDTO();
        dnaDTO.setDna(dna);
        Person person = new Person();
        person.setDna("ACGT,CTAG,TGCA,AACC");
        person.setMutant(false);

        doReturn(person).when(personRepository).save(any());

        PersonDTO savePerson = dnaService.savePerson(dnaDTO);

        Assertions.assertEquals(savePerson.getDna(), "ACGT,CTAG,TGCA,AACC");
        Assertions.assertEquals(savePerson.getMutant(), false);
    }

}
