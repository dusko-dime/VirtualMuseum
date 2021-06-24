package com.etfbl.dimitric.service.impl;

import com.etfbl.dimitric.model.dto.CityDTO;
import com.etfbl.dimitric.model.dto.MuseumDTO;
import com.etfbl.dimitric.model.entity.Museum;
import com.etfbl.dimitric.repository.MuseumRepository;
import com.etfbl.dimitric.service.MuseumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MuseumServiceImpl implements MuseumService {

    private ModelMapper modelMapper;
    private MuseumRepository museumRepository;

    public MuseumServiceImpl(ModelMapper modelMapper, MuseumRepository museumRepository){
        this.modelMapper = modelMapper;
        this.museumRepository = museumRepository;
    }

    @Override
    public List<MuseumDTO> getAllActive() {
        List<Museum> museumList = museumRepository.getAllByActive((byte)1);

        Function<Museum, MuseumDTO> mapper = el -> {
            MuseumDTO dto = modelMapper.map(el, MuseumDTO.class);
            CityDTO cityDTO = new CityDTO();
            cityDTO.setName(el.getCity().getName());
            cityDTO.setId(el.getCity().getId());
            cityDTO.setCountryName(el.getCity().getCountry().getName());
            cityDTO.setCountryCode(el.getCity().getCountry().getCode());
            cityDTO.setCountryId(el.getCity().getCountry().getId());
            dto.setCity(cityDTO);
            return dto;
        };

        return museumList.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
