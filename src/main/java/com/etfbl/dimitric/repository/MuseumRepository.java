package com.etfbl.dimitric.repository;


import com.etfbl.dimitric.model.entity.Museum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuseumRepository extends JpaRepository<Museum, Integer> {
}
