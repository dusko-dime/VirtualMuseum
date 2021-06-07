package com.etfbl.dimitric.repository;

import com.etfbl.dimitric.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
