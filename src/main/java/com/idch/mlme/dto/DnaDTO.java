package com.idch.mlme.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * DNA data transfer object model
 */
@ApiModel(value = "Dna", description = "dna")
@Data
public class DnaDTO {

    @ApiModelProperty(value = "Dna", required = true)
    String[] dna;
}
