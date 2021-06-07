package com.etfbl.dimitric.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "museum")
public class Museum {
    private Integer id;
    private String name;
    private String address;
    private String phoneNumber;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Integer museumTypeId;
    private Integer cityId;
    private Byte active;
    private MuseumType museumTypeByMuseumTypeId;
    private City cityByCityId;
    private Integer musemTypeId;
    private MuseumType museumTypeByMusemTypeId;

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
    @Column(name = "address", nullable = true, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "latitude", nullable = true, precision = 9)
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude", nullable = true, precision = 9)
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "museum_type_id", nullable = false)
    public Integer getMuseumTypeId() {
        return museumTypeId;
    }

    public void setMuseumTypeId(Integer museumTypeId) {
        this.museumTypeId = museumTypeId;
    }

    @Basic
    @Column(name = "city_id", nullable = false)
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "active", nullable = false)
    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Museum museum = (Museum) o;
        return Objects.equals(id, museum.id) &&
                Objects.equals(name, museum.name) &&
                Objects.equals(address, museum.address) &&
                Objects.equals(phoneNumber, museum.phoneNumber) &&
                Objects.equals(latitude, museum.latitude) &&
                Objects.equals(longitude, museum.longitude) &&
                Objects.equals(museumTypeId, museum.museumTypeId) &&
                Objects.equals(cityId, museum.cityId) &&
                Objects.equals(active, museum.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phoneNumber, latitude, longitude, museumTypeId, cityId, active);
    }

    @ManyToOne
    @JoinColumn(name = "museum_type_id", referencedColumnName = "id", nullable = false)
    public MuseumType getMuseumTypeByMuseumTypeId() {
        return museumTypeByMuseumTypeId;
    }

    public void setMuseumTypeByMuseumTypeId(MuseumType museumTypeByMuseumTypeId) {
        this.museumTypeByMuseumTypeId = museumTypeByMuseumTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    @Basic
    @Column(name = "musem_type_id", nullable = false)
    public Integer getMusemTypeId() {
        return musemTypeId;
    }

    public void setMusemTypeId(Integer musemTypeId) {
        this.musemTypeId = musemTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "musem_type_id", referencedColumnName = "id", nullable = false)
    public MuseumType getMuseumTypeByMusemTypeId() {
        return museumTypeByMusemTypeId;
    }

    public void setMuseumTypeByMusemTypeId(MuseumType museumTypeByMusemTypeId) {
        this.museumTypeByMusemTypeId = museumTypeByMusemTypeId;
    }
}
