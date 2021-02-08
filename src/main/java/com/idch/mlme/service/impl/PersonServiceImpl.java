package com.idch.mlme.service.impl;

import com.idch.mlme.entities.Person;
import com.idch.mlme.repository.PersonRepository;
import com.idch.mlme.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Optional<Person> findByDna(String dna) {
        return personRepository.findByDna(dna);
    }

    @Override
    public Long countByMutant(Boolean value) {
        return personRepository.countByMutant(value);
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }
}
