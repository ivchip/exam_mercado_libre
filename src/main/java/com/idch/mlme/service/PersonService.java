package com.idch.mlme.service;

import com.idch.mlme.dto.DnaDTO;
import com.idch.mlme.dto.StatisticDTO;

/**
 * Person Interface
 */
public interface PersonService {

    Short savePerson(DnaDTO dna);

    StatisticDTO calculateRatio();
}
