package com.idch.mlme.service;

import com.idch.mlme.dto.DnaDTO;
import com.idch.mlme.dto.StatisticDTO;

public interface PersonService {
    Short savePerson(DnaDTO dna);

    StatisticDTO calculateRatio();
}
