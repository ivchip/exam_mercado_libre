package com.idch.mlme.service;

import com.idch.mlme.entities.Person;

import java.util.Optional;

public interface PersonService {
    Optional<Person> findByDna(String dna);
    Long countByMutant(Boolean value);
    void savePerson(Person person);
}
