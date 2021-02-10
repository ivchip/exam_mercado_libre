package com.idch.mlme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("count_mutant_dna")
    private Long countMutantDna;
    @JsonProperty("count_human_dna")
    private Long countHumanDna;
    private Double ratio;
}
