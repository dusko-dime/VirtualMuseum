package com.etfbl.dimitric.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
public class Museum {
    @Id@Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic@Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic@Column(name = "address", nullable = true, length = 45)
    private String address;
    @Basic@Column(name = "phone_number", nullable = true, length = 20)
    private String phoneNumber;
    @Basic@Column(name = "latitude", nullable = true, precision = 9)
    private BigDecimal latitude;
    @Basic@Column(name = "longitude", nullable = true, precision = 9)
    private BigDecimal longitude;
    @Basic@Column(name = "active", nullable = false)
    private Byte active;
    @ManyToOne@JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private City city;
    @ManyToOne@JoinColumn(name="museum_type_id", nullable=false)
    private MuseumType museumType;


}
