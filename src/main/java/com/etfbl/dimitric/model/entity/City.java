package com.etfbl.dimitric.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class City {
    @Id@Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic@Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic@Column(name = "active", nullable = false, length = 45)
    private String active;
    @ManyToOne@JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private Country country;

}
