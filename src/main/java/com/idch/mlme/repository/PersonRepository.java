package com.idch.mlme.repository;

import com.idch.mlme.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Optional<Person> findByDna(String dna);
    Long countByMutant(Boolean value);
}
