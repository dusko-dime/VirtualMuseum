package com.etfbl.dimitric.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "museum_type", schema = "museum", catalog = "")
public class MuseumType {
    @Id@Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic@Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic@Column(name = "active", nullable = false, length = 45)
    private String active;
    @OneToMany(mappedBy = "museumType")
    private List<Museum> museums;

}
