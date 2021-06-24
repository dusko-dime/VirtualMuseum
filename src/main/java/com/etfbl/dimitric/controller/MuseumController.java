package com.etfbl.dimitric.controller;

import com.etfbl.dimitric.model.dto.MuseumDTO;
import com.etfbl.dimitric.service.MuseumService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("/museums")
public class MuseumController {

    private final MuseumService museumService;

    public MuseumController(MuseumService museumService) {
        this.museumService = museumService;
    }

    @GetMapping
    public List<MuseumDTO> getAllActive() {
        return museumService.getAllActive();
    }
}
