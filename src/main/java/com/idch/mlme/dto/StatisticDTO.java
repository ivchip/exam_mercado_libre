package com.idch.mlme.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Statistic data transfer object model
 */
@ApiModel(value = "Statistic", description = "statistic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticDTO {

    private Long count_mutant_dna;
    private Long count_human_dna;
    private Double ratio;
}
