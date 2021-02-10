package com.idch.mlme.service.impl;

import com.idch.mlme.dto.DnaDTO;
import com.idch.mlme.dto.StatisticDTO;
import com.idch.mlme.entities.Person;
import com.idch.mlme.repository.PersonRepository;
import com.idch.mlme.service.PersonService;
import com.idch.mlme.utils.DnaUtils;
import com.idch.mlme.utils.StatsUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Person service implementation class
 */
@Service
public class PersonServiceImpl implements PersonService {

    /**
     * Injecting dependencies
     */
    private PersonRepository personRepository;

    /**
     * Constructor
     *
     * @param personRepository
     */
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Method implementation validate if is mutant and creating new person
     *
     * @return
     */
    @Override
    public Short savePerson(DnaDTO dna) {
        if (dna.getDna() == null)
            return -1;
        if (!DnaUtils.isMinlengthMatrix(dna.getDna().length) && DnaUtils.isValidateSquareMatrixAndValues(dna.getDna())) {
            String dnaString = Arrays.toString(dna.getDna()).replaceAll("[\\[\\] ]+", "");
            Person person = new Person();
            person.setDna(dnaString);
            if (DnaUtils.isMutant(dna.getDna())) {
                person.setMutant(true);
                if (personRepository.findByDna(dnaString).isEmpty())
                    personRepository.save(person);
                return 0;
            } else {
                person.setMutant(false);
                if (personRepository.findByDna(dnaString).isEmpty())
                    personRepository.save(person);
                return -2;
            }
        } else {
            return -1;
        }
    }

    /**
     * Method implementation for calculate ratio
     *
     * @return
     */
    @Override
    public StatisticDTO calculateRatio() {
        return StatsUtils.calculateRatio(personRepository.countByMutant(false), personRepository.countByMutant(true));
    }
}
