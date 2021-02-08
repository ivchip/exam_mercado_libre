package com.idch.mlme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticDTO implements Serializable {

    private Long count_mutant_dna;
    private Long count_human_dna;
    private Double ratio;
}
