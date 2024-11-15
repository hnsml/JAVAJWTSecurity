package com.example.poemsspringsecuritydemo.mappers;

import com.example.poemsspringsecuritydemo.DTOs.PoetDTO;
import com.example.poemsspringsecuritydemo.entities.Poet;
import java.util.stream.Collectors;

public class PoetMapper {

    public static PoetDTO toDto(Poet poet) {
        if (poet == null) {
            return null;
        }

        PoetDTO poetDTO = new PoetDTO();
        poetDTO.setId(poet.getId());
        poetDTO.setName(poet.getName());
        poetDTO.setBiography(poet.getBiography());
        poetDTO.setCountry(poet.getCountry());
        poetDTO.setPoems(
                poet.getPoems().stream().map(PoemMapper::toDto).collect(Collectors.toList()));
        return poetDTO;
    }

    public static Poet toEntity(PoetDTO poetDTO) {
        if (poetDTO == null) {
            return null;
        }

        Poet poet = new Poet();
        poet.setId(poetDTO.getId());
        poet.setName(poetDTO.getName());
        poet.setBiography(poetDTO.getBiography());
        poet.setCountry(poetDTO.getCountry());
        poet.setPoems(
                poetDTO.getPoems().stream().map(PoemMapper::toEntity).collect(Collectors.toList()));
        return poet;
    }
}
