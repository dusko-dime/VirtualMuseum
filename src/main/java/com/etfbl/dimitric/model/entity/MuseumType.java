package com.etfbl.dimitric.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "museum_type", schema = "museum", catalog = "")
public class MuseumType {
    private Integer id;
    private String name;
    private String active;
    private Collection<Museum> museumsById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "active", nullable = false, length = 45)
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MuseumType that = (MuseumType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(active, that.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, active);
    }

    @OneToMany(mappedBy = "museumTypeByMusemTypeId")
    public Collection<Museum> getMuseumsById() {
        return museumsById;
    }

    public void setMuseumsById(Collection<Museum> museumsById) {
        this.museumsById = museumsById;
    }
}
