package com.idch.mlme.service;

import com.idch.mlme.dto.DnaDTO;
import com.idch.mlme.dto.PersonDTO;
import com.idch.mlme.dto.StatisticDTO;

/**
 * Person Interface
 */
public interface DnaService {

    PersonDTO savePerson(DnaDTO dna);

    StatisticDTO calculateRatio();
}
