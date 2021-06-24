package com.etfbl.dimitric.service;

import com.etfbl.dimitric.model.dto.MuseumDTO;

import java.util.List;

public interface MuseumService {
    List<MuseumDTO> getAllActive();
}
