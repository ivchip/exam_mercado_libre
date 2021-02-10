package com.idch.mlme.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * PersonDTO data transfer object model
 */
@ApiModel(value = "PersonDTO", description = "personDTO")
@Data
public class PersonDTO {

    @ApiModelProperty(value = "Dna")
    private String dna;
    @ApiModelProperty(value = "Mutant")
    private Boolean mutant;
}
