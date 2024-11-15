package com.example.poemsspringsecuritydemo.controllers;

import com.example.poemsspringsecuritydemo.DTOs.PoetDTO;
import com.example.poemsspringsecuritydemo.services.PoetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/poets")
public class PoetController {

    @Autowired
    private PoetService poetService;

    @GetMapping("/{poetName}/biography")
    public PoetDTO getPoetBiography(@PathVariable String poetName) {
        return poetService.getPoetBiography(poetName);
    }

    @GetMapping("/top")
    public List<PoetDTO> getTopPoets() {
        return poetService.getTopPoets();
    }

    @GetMapping("/country/{country}/top")
    public List<PoetDTO> getTopPoetsByCountry(@PathVariable String country) {
        return poetService.getTopPoetsByCountry(country);
    }
}

