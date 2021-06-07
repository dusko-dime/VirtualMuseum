package com.etfbl.dimitric.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City {
    private Integer id;
    private String name;
    private Integer countryId;
    private String active;
    private Country countryByCountryId;
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
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "country_id", nullable = false)
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
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
        City city = (City) o;
        return Objects.equals(id, city.id) &&
                Objects.equals(name, city.name) &&
                Objects.equals(countryId, city.countryId) &&
                Objects.equals(active, city.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countryId, active);
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    public Country getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(Country countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<Museum> getMuseumsById() {
        return museumsById;
    }

    public void setMuseumsById(Collection<Museum> museumsById) {
        this.museumsById = museumsById;
    }
}
