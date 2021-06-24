package com.etfbl.dimitric.model.dto;

import lombok.Data;

@Data
public class CityDTO {
    private Integer id;
    private String name;
    private Integer countryId;
    private String countryName;
    private String countryCode;
}
