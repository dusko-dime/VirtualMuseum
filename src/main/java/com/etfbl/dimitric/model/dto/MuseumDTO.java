package com.etfbl.dimitric.model.dto;

import com.etfbl.dimitric.model.entity.City;
import com.etfbl.dimitric.model.entity.MuseumType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MuseumDTO {
    private Integer id;
    private String name;
    private String address;
    private String phoneNumber;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private MuseumType museumType;
    private CityDTO city;
}
