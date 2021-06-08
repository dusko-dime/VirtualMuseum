package com.etfbl.dimitric.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Country {
    @Id@Column(name = "id", nullable = false)
    private Integer id;
    @Basic@Column(name = "code", nullable = false, length = 3)
    private String code;
    @Basic@Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic@Column(name = "active", nullable = false)
    private Byte active;
    @OneToMany(mappedBy = "country")
    private List<City> cities;

}
