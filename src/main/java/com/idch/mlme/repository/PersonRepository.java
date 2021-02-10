package com.idch.mlme.repository;

import com.idch.mlme.entities.Person;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Person repository class for database interaction
 */
@Api(tags = "Person Entity")
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    /**
     * Getting person based on the provided dna
     *
     * @param dna
     * @return
     */
    Optional<Person> findByDna(String dna);

    /**
     * Getting value based on the provided is mutant
     *
     * @param isMutant
     * @return
     */
    Long countByMutant(Boolean isMutant);
}
