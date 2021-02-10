package com.idch.mlme.service.impl;

import com.idch.mlme.dto.DnaDTO;
import com.idch.mlme.dto.PersonDTO;
import com.idch.mlme.dto.StatisticDTO;
import com.idch.mlme.entities.Person;
import com.idch.mlme.repository.PersonRepository;
import com.idch.mlme.service.DnaService;
import com.idch.mlme.utils.DnaUtils;
import com.idch.mlme.utils.StatsUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Person service implementation class
 */
@Service
public class DnaServiceImpl implements DnaService {

    /**
     * Injecting dependencies
     */
    private PersonRepository personRepository;

    /**
     * Constructor
     *
     * @param personRepository
     */
    public DnaServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Method implementation validate if is mutant and creating new person
     *
     * @return
     */
    @Override
    public PersonDTO savePerson(DnaDTO dna) {
        ModelMapper modelMapper = new ModelMapper();
        String dnaString = String.join(",", dna.getDna());
        Person person = new Person();
        person.setDna(dnaString);
        if (DnaUtils.isMutant(dna.getDna())) {
            person.setMutant(true);
        } else {
            person.setMutant(false);
        }
        if (personRepository.findByDna(dnaString).isEmpty())
            personRepository.save(person);
        PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);
        return personDTO;
    }

    /**
     * Method implementation for calculate ratio
     *
     * @return
     */
    @Override
    public StatisticDTO calculateRatio() {
        List<Object[]> result = personRepository.groupByAndCountByMutant();
        Long numHuman = 0L;
        Long numMutant = 0L;
        if (!result.isEmpty()) {
            for (Object[] l : result) {
                if ((Boolean) l[0]) {
                    numMutant = (Long) l[1];
                } else {
                    numHuman = (Long) l[1];
                }
            }
        }
        return StatsUtils.calculateRatio(numHuman, numMutant);
    }
}
