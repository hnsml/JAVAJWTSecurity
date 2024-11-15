package com.example.poemsspringsecuritydemo.services;

import com.example.poemsspringsecuritydemo.DTOs.PoetDTO;
import com.example.poemsspringsecuritydemo.entities.Poet;
import com.example.poemsspringsecuritydemo.mappers.PoetMapper;
import com.example.poemsspringsecuritydemo.repositories.PoetRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoetService {

    @Autowired
    private PoetRepository poetRepository;

    public PoetDTO getPoetBiography(String poetName) {
        Poet poet = poetRepository.findByName(poetName);
        return PoetMapper.toDto(poet);
    }

    public List<PoetDTO> getTopPoets() {
        return poetRepository.findTopPoets().stream()
                .map(PoetMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<PoetDTO> getTopPoetsByCountry(String country) {
        return poetRepository.findTopPoetsByCountry(country).stream()
                .map(PoetMapper::toDto)
                .collect(Collectors.toList());
    }
}

