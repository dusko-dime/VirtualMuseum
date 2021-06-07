package com.etfbl.dimitric.repository;

import com.etfbl.dimitric.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
